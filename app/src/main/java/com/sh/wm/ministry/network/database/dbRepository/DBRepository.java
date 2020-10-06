package com.sh.wm.ministry.network.database.dbRepository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.sh.wm.ministry.network.database.DataBase;
import com.sh.wm.ministry.network.database.dao.CitiesDao;
import com.sh.wm.ministry.network.database.dao.ConstantsDao;
import com.sh.wm.ministry.network.database.dao.CountriesDao;
import com.sh.wm.ministry.network.database.dao.DirectorsDao;
import com.sh.wm.ministry.network.database.dao.EduProgramDao;
import com.sh.wm.ministry.network.database.dao.EducationalInstituteDao;
import com.sh.wm.ministry.network.database.dao.JobTitlesDao;
import com.sh.wm.ministry.network.database.dao.JobsDao;
import com.sh.wm.ministry.network.database.dao.LanguagesDao;

import com.sh.wm.ministry.network.database.dao.MunicipalitiesDao;
import com.sh.wm.ministry.network.database.dao.RegionsDao;
import com.sh.wm.ministry.network.database.dao.TrainingInstituteDao;
import com.sh.wm.ministry.network.database.dao.TrainingProgramDao;
import com.sh.wm.ministry.network.database.dao.WorkStatusDao;
import com.sh.wm.ministry.network.database.dbModels.cities.CitiesModel;
import com.sh.wm.ministry.network.database.dbModels.cities.City;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.constants.ConstantsModel;
import com.sh.wm.ministry.network.database.dbModels.countries.CountriesModel;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.database.dbModels.directors.Director;
import com.sh.wm.ministry.network.database.dbModels.directors.DirectorsModel;
import com.sh.wm.ministry.network.database.dbModels.educationalinstitutes.EducationalInstitute;
import com.sh.wm.ministry.network.database.dbModels.educationalinstitutes.EducationalInstitutesModel;
import com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgram;
import com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgramsModel;
import com.sh.wm.ministry.network.database.dbModels.jobs.Job;
import com.sh.wm.ministry.network.database.dbModels.jobs.JobsModel;
import com.sh.wm.ministry.network.database.dbModels.jobtitles.JobTitle;
import com.sh.wm.ministry.network.database.dbModels.jobtitles.JobTitlesModel;
import com.sh.wm.ministry.network.database.dbModels.languages.LanguagesModel;
import com.sh.wm.ministry.network.database.dbModels.languages.Language;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.Municipality;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.MunicipalityModel;
import com.sh.wm.ministry.network.database.dbModels.regions.Region;
import com.sh.wm.ministry.network.database.dbModels.regions.RegionsModel;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitute;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitutesModel;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgramsModel;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatus;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatusModel;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DBRepository {
    private static DBRepository mInstance;
    private final String TAG = DBRepository.class.getName();
    private NetworkUtils networkUtils;
    private CountriesDao countriesDao;
    private LanguagesDao languagesDao;
    private WorkStatusDao workStatusDao;
    private JobsDao jobsDao;
    private ConstantsDao constantsDao;
    private MunicipalitiesDao municipalitiesDao;
    private RegionsDao regionsDao;
    private JobTitlesDao jobTitlesDao;
    private CitiesDao citiesDao;
    private DirectorsDao directorsDao;
    private EduProgramDao eduProgramDao;
    private EducationalInstituteDao educationalInstituteDao;
    private TrainingInstituteDao trainingInstituteDao;
    private TrainingProgramDao trainingProgramDao;


    private DBRepository(Application application) {
        networkUtils = NetworkUtils.getInstance(true, application);
        countriesDao = DataBase.getInstance(application).countriesDao();
        languagesDao = DataBase.getInstance(application).languagesDao();
        workStatusDao = DataBase.getInstance(application).workStatusDao();
        jobsDao = DataBase.getInstance(application).jobsDao();
        constantsDao = DataBase.getInstance(application).constantsDao();
        municipalitiesDao = DataBase.getInstance(application).municipalitiesDao();
        regionsDao = DataBase.getInstance(application).regionsDao();
        jobTitlesDao = DataBase.getInstance(application).jobTitlesDao();
        citiesDao = DataBase.getInstance(application).citiesDao();
        directorsDao = DataBase.getInstance(application).directorsDao();
        eduProgramDao = DataBase.getInstance(application).eduProgramDao();
        educationalInstituteDao = DataBase.getInstance(application).educationalInstituteDao();
        trainingInstituteDao = DataBase.getInstance(application).trainingInstituteDao();
        trainingProgramDao = DataBase.getInstance(application).trainingProgramDao();
    }

    public static DBRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new DBRepository(application);
        }
        return mInstance;
    }

    //countries
    public LiveData<List<Country>> getAllCountries() {
        updateCountries();
        return countriesDao.getAllCountries();
    }

    public Country getUserCountry(String countryID){
        updateCountries();
        return countriesDao.getUserCountry(countryID);
    }

    public void updateCountries() {
        networkUtils.getApiInterface().getCountries().enqueue(new Callback<CountriesModel>() {
            @Override
            public void onResponse(Call<CountriesModel> call, Response<CountriesModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCountries().size() != countriesDao.getDataCount()) {
                        List<Country> countries = response.body().getCountries();
                        for (Country country : countries)
                            countriesDao.addCountry(country);
                    }
                }
            }

            @Override
            public void onFailure(Call<CountriesModel> call, Throwable t) {
            }
        });
    }

    // languages
    public LiveData<List<Language>> getAllLanguages() {
        updateLanguages();
        return languagesDao.getAllLanguages();
    }

    public void updateLanguages() {
        networkUtils.getApiInterface().getLanguages().enqueue(new Callback<LanguagesModel>() {
            @Override
            public void onResponse(Call<LanguagesModel> call, Response<LanguagesModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "All Languages Response Received!");
                        Log.d(TAG, "response size" + response.body().getLanguages().size() + " db size " + languagesDao.getDataCount());
                        if (response.body().getLanguages().size() != languagesDao.getDataCount()) {

                            List<Language> languages = response.body().getLanguages();
                            for (Language language : languages) {
                                languagesDao.addLanguage(language);
                                Log.d(TAG, language.getLANGUAGEARNAME() + "");
                                Log.d(TAG, languagesDao.getDataCount() + "");

                            }
                        }
                    }
                } else {
                    Log.d(TAG, "All Languages Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<LanguagesModel> call, Throwable t) {
                Log.e(TAG, "All Languages request has failed!");
            }
        });
    }

    //work status
    public LiveData<List<WorkStatus>> getAllWorkStatuses() {
        updateWorkStatus();
        return workStatusDao.getAllWorkStatuses();
    }

    public void updateWorkStatus() {
        networkUtils.getApiInterface().getWorkStatus().enqueue(new Callback<WorkStatusModel>() {
            @Override
            public void onResponse(Call<WorkStatusModel> call, Response<WorkStatusModel> response) {
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "All Work Statuses Response Received!");
                        Log.d(TAG, "response size" + response.body().getWorkStatus().size() + " db size " + workStatusDao.getDataCount());
                        if (response.body().getWorkStatus().size() != workStatusDao.getDataCount()) {

                            List<WorkStatus> workStatuses = response.body().getWorkStatus();
                            for (WorkStatus workStatus : workStatuses) {
                                workStatusDao.addWorkStatus(workStatus);
                                Log.d(TAG, workStatus.getWORKSTATUSNAME() + "");
                                Log.d(TAG, workStatusDao.getDataCount() + "");

                            }
                        }
                    }
                } else {
                    Log.d(TAG, "All Work Statuses Empty Response!");
                }
            }

            @Override
            public void onFailure(Call<WorkStatusModel> call, Throwable t) {
                Log.e(TAG, "All Work Statuses request has failed!");
            }
        });
    }

    //jobs
    public LiveData<List<Job>> getAllJobs() {
        updateJobs();
        return jobsDao.getAllJobs();
    }

    public void updateJobs() {
        networkUtils.getApiInterface().getJobs().enqueue(new Callback<JobsModel>() {
            @Override
            public void onResponse(Call<JobsModel> call, Response<JobsModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getJobs().size() != jobsDao.getDataCount()) {
                        List<Job> jobs = response.body().getJobs();
                        for (Job job : jobs)
                            jobsDao.addJob(job);
                    }
                }
            }

            @Override
            public void onFailure(Call<JobsModel> call, Throwable t) {
            }
        });
    }

    //constants
    public LiveData<List<Constants>> getAllConstants(String constantId) {
        updateConstants(constantId);
        return constantsDao.getConstants(constantId);
    }

    public void updateConstants(String constantId) {
        networkUtils.getApiInterface().getConstants(constantId).enqueue(new Callback<ConstantsModel>() {
            @Override
            public void onResponse(Call<ConstantsModel> call, Response<ConstantsModel> response) {
                if (response.body() != null) {
                    List<String> apiDates = new ArrayList<>();
                    List<String> dbDates = new ArrayList<>();
                    for (Constants constant : response.body().getConstants()) {
                        if (!constant.getUPDATEDATE().toString().equals("null"))
                            System.out.println(" api : " + constant.getUPDATEDATE().toString() + " constant : " + constant.getCONSTANTARANAME());
//                            apiDates.add(constant.getUPDATEDATE().toString());
                    }
//                    long maxApiDate = MaxDate(apiDates);
                    for (Object object : constantsDao.getMaxDate(constantId)) {
                        if (!object.toString().equals("null"))
                            System.out.println(" object : " + object.toString());
//                            dbDates.add(object.toString());
                    }
//                    long maxDbDate = MaxDate(dbDates);
//                    if (maxApiDate != -1 && maxDbDate != -1)
//                        if (maxApiDate != maxDbDate)
//                            System.out.println("the two dates do not match");
                    if (response.body().getConstants().size() != constantsDao.getDataCount(constantId)) {
                        List<Constants> constants = response.body().getConstants();
                        for (Constants constant : constants) {
                            constantsDao.addConstant(constant);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ConstantsModel> call, Throwable t) {
                Log.e(TAG, "All Work Statuses request has failed!");
            }
        });
    }

    public long MaxDate(List<String> dates) {
        if (dates.isEmpty())
            return -1;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
        Date maxDate = null;
        try {
            maxDate = sdf.parse(dates.get(0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < dates.size(); i++) {
            System.out.println(dates.get(i));
            Date strDate = null;
            try {
                strDate = sdf.parse(dates.get(i));
            } catch (ParseException e) {
                e.printStackTrace();
            }
//            if (strDate.getTime() > maxDate.getTime()) {
//                System.out.println("wejdan date" + strDate.getTime() + "   " + maxDate.getTime());
//                maxDate = strDate;
//            } else {
//                System.out.println("wejdan date" + strDate.getTime() + "   " + maxDate.getTime());
//            }
        }
//        return maxDate.getTime();
        return -1;
    }

    //municipalities
    public LiveData<List<Municipality>> getAllMunicipalities() {
        updateMunicipalities();
        return municipalitiesDao.getAllMunicipalities();
    }

    public void updateMunicipalities() {
        Log.d(TAG, "getAllMunicipality: " + "sohaib hassan");
        Call<MunicipalityModel> call = networkUtils.getApiInterface().getMunicipalities();
        call.enqueue(new Callback<MunicipalityModel>() {
            @Override
            public void onResponse(@NotNull Call<MunicipalityModel> call, @NotNull Response<MunicipalityModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getMunicipalities().size() != municipalitiesDao.getDataCount()) {
                        List<Municipality> municipalities = response.body().getMunicipalities();
                        for (Municipality municipality : municipalities)
                            municipalitiesDao.addMunicipality(municipality);
                    }
                }
            }

            @Override
            public void onFailure(Call<MunicipalityModel> call, Throwable t) {
            }
        });
    }

    //regions
    public LiveData<List<Region>> getAllRegions() {
        updateRegions();
        return regionsDao.getAllRegions();
    }

    public void updateRegions() {
        Call<RegionsModel> call = networkUtils.getApiInterface().getRegions();
        call.enqueue(new Callback<RegionsModel>() {
            @Override
            public void onResponse(Call<RegionsModel> call, Response<RegionsModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getRegions().size() != regionsDao.getDataCount()) {
                        List<Region> regions = response.body().getRegions();
                        for (Region region : regions)
                            regionsDao.addRegion(region);
                    }
                }
            }

            @Override
            public void onFailure(Call<RegionsModel> call, Throwable t) {
            }
        });
    }

    //job titles
    public LiveData<List<JobTitle>> getAllJobTitles() {
        updateJobTitles();
        return jobTitlesDao.getAllJobTitles();
    }

    public void updateJobTitles() {
        Call<JobTitlesModel> call = networkUtils.getApiInterface().getJobTitles();
        call.enqueue(new Callback<JobTitlesModel>() {
            @Override
            public void onResponse(Call<JobTitlesModel> call, Response<JobTitlesModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getJobTitles().size() != jobTitlesDao.getDataCount()) {
                        List<JobTitle> jobTitles = response.body().getJobTitles();
                        for (JobTitle jobTitle : jobTitles)
                            jobTitlesDao.addJobTitle(jobTitle);
                    }
                }
            }

            @Override
            public void onFailure(Call<JobTitlesModel> call, Throwable t) {
            }
        });
    }

    //cities
    public LiveData<List<City>> getAllCities() {
        updateCities();
        return citiesDao.getAllCities();
    }

    public void updateCities() {
        networkUtils.getApiInterface().getCities().enqueue(new Callback<CitiesModel>() {
            @Override
            public void onResponse(Call<CitiesModel> call, Response<CitiesModel> response) {
                if (response.isSuccessful())
                    if (response.body().getCities().size() != citiesDao.getDataCount())
                        for (City city : response.body().getCities())
                            citiesDao.addCity(city);
            }

            @Override
            public void onFailure(Call<CitiesModel> call, Throwable t) {
            }
        });
    }

    //directors
    public LiveData<List<Director>> getAllDirectors() {
        updateDirectors();
        return directorsDao.getAllDirectors();
    }

    public void updateDirectors() {
        networkUtils.getApiInterface().getDirectors().enqueue(new Callback<DirectorsModel>() {
            @Override
            public void onResponse(Call<DirectorsModel> call, Response<DirectorsModel> response) {
                if (response.isSuccessful())
                    if (response.body().getDirectors().size() != directorsDao.getDataCount())
                        for (Director director : response.body().getDirectors())
                            directorsDao.addDirector(director);
            }

            @Override
            public void onFailure(Call<DirectorsModel> call, Throwable t) {
            }
        });
    }

    //edu programs
    public LiveData<List<EduProgram>> getAllEduPrograms() {
        updateEduPrograms();
        return eduProgramDao.getAllEduPrograms();
    }

    public void updateEduPrograms() {
        networkUtils.getApiInterface().getEduPrograms().enqueue(new Callback<EduProgramsModel>() {
            @Override
            public void onResponse(Call<EduProgramsModel> call, Response<EduProgramsModel> response) {
                if (response.isSuccessful())
                    if (response.body().getEduPrograms().size() != eduProgramDao.getDataCount())
                        for (EduProgram eduProgram : response.body().getEduPrograms())
                            eduProgramDao.addEduProgram(eduProgram);
            }

            @Override
            public void onFailure(Call<EduProgramsModel> call, Throwable t) {
            }
        });
    }

    //educational institutes
    public LiveData<List<EducationalInstitute>> getAllEducationalInstitutes() {
        updateEducationalInstitutes();
        return educationalInstituteDao.getAllEducationalInstitutes();
    }

    public void updateEducationalInstitutes() {
        networkUtils.getApiInterface().getEducationalInstitutes().enqueue(new Callback<EducationalInstitutesModel>() {
            @Override
            public void onResponse(Call<EducationalInstitutesModel> call, Response<EducationalInstitutesModel> response) {
                if (response.isSuccessful())
                    if (response.body().getEducationalInstitutes().size() != educationalInstituteDao.getDataCount())
                        for (EducationalInstitute educationalInstitute : response.body().getEducationalInstitutes())
                            educationalInstituteDao.addEducationalInstitute(educationalInstitute);
            }

            @Override
            public void onFailure(Call<EducationalInstitutesModel> call, Throwable t) {
            }
        });
    }

    //training institutes
    public LiveData<List<TrainingInstitute>> getAllTrainingInstitutes() {
        updateTrainingInstitutes();
        return trainingInstituteDao.getAllTrainingInstitutes();
    }

    public void updateTrainingInstitutes() {
        networkUtils.getApiInterface().getTrainingInstitutes().enqueue(new Callback<TrainingInstitutesModel>() {
            @Override
            public void onResponse(Call<TrainingInstitutesModel> call, Response<TrainingInstitutesModel> response) {
                if (response.isSuccessful())
                    if (response.body().getTrainingInstitutes().size() != trainingInstituteDao.getDataCount())
                        for (TrainingInstitute trainingInstitute : response.body().getTrainingInstitutes())
                            trainingInstituteDao.addTrainingInstitute(trainingInstitute);
            }

            @Override
            public void onFailure(Call<TrainingInstitutesModel> call, Throwable t) {
            }
        });
    }

    //training programs
    public LiveData<List<TrainingProgram>> getAllTrainingPrograms() {
        updateTrainingPrograms();
        return trainingProgramDao.getAllTrainingPrograms();
    }

    public void updateTrainingPrograms() {
        networkUtils.getApiInterface().getTrainingPrograms().enqueue(new Callback<TrainingProgramsModel>() {
            @Override
            public void onResponse(Call<TrainingProgramsModel> call, Response<TrainingProgramsModel> response) {
                if (response.isSuccessful())
                    if (response.body().getTrainingPrograms().size() != trainingProgramDao.getDataCount())
                        for (TrainingProgram trainingProgram : response.body().getTrainingPrograms())
                            trainingProgramDao.addTrainingProgram(trainingProgram);
            }

            @Override
            public void onFailure(Call<TrainingProgramsModel> call, Throwable t) {
            }
        });
    }

}
