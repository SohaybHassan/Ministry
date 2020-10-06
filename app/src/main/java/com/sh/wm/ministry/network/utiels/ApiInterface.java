package com.sh.wm.ministry.network.utiels;


import com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model.ArchiveModel;
import com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model.PalLaw;
import com.sh.wm.ministry.featuers.home.homeFiles.closeFacility.model.CloseFacilityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model.ConstructByName;
import com.sh.wm.ministry.featuers.home.model.CertificateRequest;
import com.sh.wm.ministry.featuers.sso.model.loginmodel.LoginModel;
import com.sh.wm.ministry.featuers.userfile.majorservices.model.UserInfoModel;
import com.sh.wm.ministry.network.database.dbModels.directors.DirectorsModel;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.MunicipalityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.PoastDataMoveFacility;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.StreetGroup;
import com.sh.wm.ministry.featuers.sso.model.SsoTokenModel;
import com.sh.wm.ministry.featuers.sso.model.UserInfoSsoModel;
import com.sh.wm.ministry.featuers.userfile.addressAndContact.model.userworkcontact.UserWorkContactModel;
import com.sh.wm.ministry.featuers.userfile.career.model.UserCareerModel;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserDependentsModel;
import com.sh.wm.ministry.featuers.userfile.dependents.model.UserWorkerInsertModel;
import com.sh.wm.ministry.featuers.userfile.educationalstatus.model.EducationalStatusModel;
import com.sh.wm.ministry.featuers.userfile.health.model.health.UserHealthStatusModel;
import com.sh.wm.ministry.network.database.dbModels.cities.CitiesModel;
import com.sh.wm.ministry.network.database.dbModels.constants.ConstantsModel;
import com.sh.wm.ministry.network.database.dbModels.countries.CountriesModel;
import com.sh.wm.ministry.network.database.dbModels.educationalinstitutes.EducationalInstitutesModel;
import com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgramsModel;
import com.sh.wm.ministry.network.database.dbModels.jobs.JobsModel;
import com.sh.wm.ministry.network.database.dbModels.jobtitles.JobTitlesModel;
import com.sh.wm.ministry.network.database.dbModels.languages.LanguagesModel;
import com.sh.wm.ministry.featuers.userfile.languages.model.UserLanguagesModel;
import com.sh.wm.ministry.featuers.userfile.practicalstatus.model.PracticalStatusModel;
import com.sh.wm.ministry.network.database.dbModels.regions.RegionsModel;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitutesModel;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgramsModel;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatusModel;
import com.sh.wm.ministry.featuers.userfile.trainingskills.model.TrainingSkillsModel;
import com.sh.wm.ministry.featuers.userfile.workexperience.model.UserWorkExperienceModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    // login requests ///////////////////////////////////////////////////////////////
    // sso login - get user token
    @FormUrlEncoded
    @POST("sso/module.php/sspoauth2/token.php")
    Call<SsoTokenModel> getSsoAccessToken(@Field("client_id") String clientId, @Field("client_secret") String secret, @Field("code") String code);

    // sso verify token
    @POST("sso/module.php/sspoauth2/verify.php")
    Call<UserInfoSsoModel> verifyToken(@Header("x-sso-authorization") String ssoToken);

    // lmis login - get user info
    @FormUrlEncoded
    @POST("login")
    Call<LoginModel> LogIn(@Field("user_sn") String userSn);

    // user files calls ////////////////////////////////////////////////////////////////
    // major services
    @GET("get_my_data")
    Call<UserInfoModel> getUserInfo();



    //contact and address
    @FormUrlEncoded
    @POST("get_user_contact")
    Call<UserWorkContactModel> getUserWorkContact(@Field("user_id") String userId);

    //dependent
    @FormUrlEncoded
    @POST("get_user_dependent")
    Call<UserDependentsModel> getUserDependents(@Field("user_id") String userId);

    @FormUrlEncoded
    @POST("user_worker_insert_dependents")
    Call<UserWorkerInsertModel> setNewDependents(@Field("user_sn") String userSn, @Field("dependent_sn") String dependentSn);

    //health
    @FormUrlEncoded
    @POST("get_user_health_status")
    Call<UserHealthStatusModel> getUserHealthStauts(@Field("user_id") String userId);

    //educational status
    @FormUrlEncoded
    @POST("get_user_educational_status")
    Call<EducationalStatusModel> getEducationlStatus(@Field("user_id") String userId);

    //career
    @FormUrlEncoded
    @POST("get_user_career")
    Call<UserCareerModel> getUserCareers(@Field("user_id") String userId);

    //work experience
    @FormUrlEncoded
    @POST("get_user_work_experience")
    Call<UserWorkExperienceModel> getUserWorkExperiences(@Field("user_id") String userId);

    // languages
    @FormUrlEncoded
    @POST("get_user_language")
    Call<UserLanguagesModel> getUserLanguages(@Field("user_id") String userId);

    //work status
    @FormUrlEncoded
    @POST("get_user_work_status")
    Call<PracticalStatusModel> getUserPracticalStatus(@Field("user_id") String userId);

    //training skills
    @FormUrlEncoded
    @POST("get_user_skills_need")
    Call<TrainingSkillsModel> getTrainingSkills(@Field("user_id") String userId);

    //constants//////////////////////////////////////////////////////////////////////////
    // countries
    @GET("get_all_countries")
    Call<CountriesModel> getCountries();

    // languages
    @GET("get_all_languages")
    Call<LanguagesModel> getLanguages();

    //work status
    @GET("get_work_status")
    Call<WorkStatusModel> getWorkStatus();

    //jobs
    @GET("get_all_jobs")
    Call<JobsModel> getJobs();

    //constants
    @GET("get_const_by_parent_id?parent_id=")
    Call<ConstantsModel> getConstants(@Query("parent_id") String parent_id);

    //municipalities
    @GET("get_all_municipality")
    Call<MunicipalityModel> getMunicipalities();

    //regions
    @GET("get_all_regions")
    Call<RegionsModel> getRegions();

    //job titles
    @GET("get_job_title")
    Call<JobTitlesModel> getJobTitles();

    //cities
    @GET("get_all_cities")
    Call<CitiesModel> getCities();

    //directors
    @GET("get_all_director")
    Call<DirectorsModel> getDirectors();

    //edu programs
    @GET("get_edu_program")
    Call<EduProgramsModel> getEduPrograms();

    //educational institutes
    @GET("get_educational_institutes")
    Call<EducationalInstitutesModel> getEducationalInstitutes();

    //training institutes
    @GET("get_training_institutes")
    Call<TrainingInstitutesModel> getTrainingInstitutes();

    //training programs
    @GET("get_training_programs")
    Call<TrainingProgramsModel> getTrainingPrograms();

    //end of constants//////////////////////////////////////////////////////////////////////

    @FormUrlEncoded
    @POST("construction_change_place")
    Call<PoastDataMoveFacility> CheangePlace(@Field("cnstruction_id") String cnstruction_id, @Field("address_id") String address_id, @Field("municipapiity_id") String municipapiity_id, @Field("region_id") String region_id,
                                             @Field("street_id") String street_id, @Field("bulding_no") String bulding_no, @Field("address_desc") String address_desc, @Field("x_direction") String x_direction, @Field("y_direction") String y_direction,
                                             @Field("construction_tele") String construction_tele, @Field("construction_mobile") String construction_mobile, @Field("construction_fax") String construction_fax, @Field("construction_box") String construction_box,
                                             @Field("construction_url") String construction_url);

    @GET("get_all_streets")
    Call<StreetGroup> getAllStreets();

    @GET("get_construct_by_num?construct_num=")
    Call<ConstructionGroup> getDataConstruction(@Query("construct_num") String nu_construction);

    @GET("get_paletinian_law_desc?PAL_LAW_ARTICAL_NUM=")
    Call<PalLaw> getPalLaw(@Query("PAL_LAW_ARTICAL_NUM") String palLaw);

    @FormUrlEncoded
    @POST("construction_close")
    Call<CloseFacilityModel> postCloseFacility(@Field("CONSTRUCT_ID") String CONSTRUCT_ID, @Field("CLOSE_DATE") String CLOSE_DATE, @Field("CLOSE_REASON") String CLOSE_REASON, @Field("INSERT_USERID") String INSERT_USERID);

    @GET("search_construct_by_using_name?construct_name=")
    Call<ConstructByName> getConstructByName(@Query("construct_name") String ConstructNumber);

    @FormUrlEncoded
    @POST("qyed_request_for_user")
    Call<CertificateRequest> requestCertificate(@Field("QAYED_USER_ID") String userId);

    @FormUrlEncoded
    @POST("get_user_qayed_archive")
    Call<ArchiveModel> requestArchive(@Field("user_id") String userId);
}
