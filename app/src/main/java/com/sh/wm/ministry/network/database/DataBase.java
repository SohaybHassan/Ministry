package com.sh.wm.ministry.network.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.sh.wm.ministry.network.database.dao.CitiesDao;
import com.sh.wm.ministry.network.database.dao.DirectorsDao;
import com.sh.wm.ministry.network.database.dao.EduProgramDao;
import com.sh.wm.ministry.network.database.dao.EducationalInstituteDao;
import com.sh.wm.ministry.network.database.dao.JobTitlesDao;
import com.sh.wm.ministry.network.database.dao.MunicipalitiesDao;
import com.sh.wm.ministry.network.database.dao.RegionsDao;
import com.sh.wm.ministry.network.database.dao.TrainingInstituteDao;
import com.sh.wm.ministry.network.database.dao.TrainingProgramDao;
import com.sh.wm.ministry.network.database.dbModels.cities.City;
import com.sh.wm.ministry.network.database.dbModels.directors.Director;
import com.sh.wm.ministry.network.database.dbModels.educationalinstitutes.EducationalInstitute;
import com.sh.wm.ministry.network.database.dbModels.eduprograms.EduProgram;
import com.sh.wm.ministry.network.database.dbModels.jobtitles.JobTitle;
import com.sh.wm.ministry.network.database.dbModels.muniplicities.Municipality;
import com.sh.wm.ministry.network.database.convertors.DBConverter;
import com.sh.wm.ministry.network.database.dao.ConstantsDao;
import com.sh.wm.ministry.network.database.dao.CountriesDao;
import com.sh.wm.ministry.network.database.dao.JobsDao;
import com.sh.wm.ministry.network.database.dao.LanguagesDao;
import com.sh.wm.ministry.network.database.dao.WorkStatusDao;
import com.sh.wm.ministry.network.database.dbModels.constants.Constants;
import com.sh.wm.ministry.network.database.dbModels.countries.Country;
import com.sh.wm.ministry.network.database.dbModels.jobs.Job;
import com.sh.wm.ministry.network.database.dbModels.languages.Language;
import com.sh.wm.ministry.network.database.dbModels.regions.Region;
import com.sh.wm.ministry.network.database.dbModels.traininginstitutes.TrainingInstitute;
import com.sh.wm.ministry.network.database.dbModels.trainingprograms.TrainingProgram;
import com.sh.wm.ministry.network.database.dbModels.workstatus.WorkStatus;


@Database(entities = {Language.class, WorkStatus.class, Constants.class, Job.class, Country.class, Municipality.class, Region.class, JobTitle.class,
        City.class, Director.class, EduProgram.class, EducationalInstitute.class, TrainingInstitute.class, TrainingProgram.class}, version = 1, exportSchema = false)
@TypeConverters({DBConverter.class})

public abstract class DataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "db_ministry";
    private static DataBase sInstance;

    public static DataBase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    DataBase.class,
                    DATABASE_NAME).allowMainThreadQueries().build();

        }
        return sInstance;
    }

    public abstract CountriesDao countriesDao();
    public abstract LanguagesDao languagesDao();
    public abstract WorkStatusDao workStatusDao();
    public abstract JobsDao jobsDao();
    public abstract ConstantsDao constantsDao();
    public abstract MunicipalitiesDao municipalitiesDao();
    public abstract RegionsDao regionsDao();
    public abstract JobTitlesDao jobTitlesDao();
    public abstract CitiesDao citiesDao();
    public abstract DirectorsDao directorsDao();
    public abstract EduProgramDao eduProgramDao();
    public abstract EducationalInstituteDao educationalInstituteDao();
    public abstract TrainingInstituteDao trainingInstituteDao();
    public abstract TrainingProgramDao trainingProgramDao();

}
