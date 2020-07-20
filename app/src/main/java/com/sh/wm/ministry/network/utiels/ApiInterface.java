package com.sh.wm.ministry.network.utiels;


import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.MoveFacilityModel;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.MunicipalityGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.RegionGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.StreetGroup;
import com.sh.wm.ministry.featuers.sso.model.SsoTokenModel;
import com.sh.wm.ministry.featuers.sso.model.UserInfoSsoModel;
import com.sh.wm.ministry.featuers.sso.model.userrole.UserRoleModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.addressAndContact.model.userworkcontact.UserWorkContactModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.career.model.UserCareerModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.dependents.model.UserDependentsModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.dependents.model.UserWorkerInsertModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.educationalstatus.model.EducationalStatusModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.health.model.health.UserHealthStatusModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.languages.model.AllLanguagesModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.languages.model.UserLanguagesModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.model.PracticalStatusModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.practicalstatus.model.WorkStatusModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.trainingskills.model.TrainingSkillsModel;
import com.sh.wm.ministry.featuers.userfile.userFiles.workexperience.model.UserWorkExperienceModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("sso/module.php/sspoauth2/token.php")
    Call<SsoTokenModel> getSsoAccessToken(@Field("client_id") String clientId, @Field("client_secret") String secret, @Field("code") String code);

    @POST("sso/module.php/sspoauth2/verify.php")
    Call<UserInfoSsoModel> verifyToken(@Header("x-sso-authorization") String ssoToken);

    @FormUrlEncoded
    @POST("login")
    Call<UserRoleModel> getUserRole(@Field("user_sn") String userSn);

    @GET("get_my_data")
    Call<UserRoleModel> getUserWorkInfo();

    @FormUrlEncoded
    @POST("get_user_contact")
    Call<UserWorkContactModel> getUserWorkContact(@Field("user_id") String userId);

    //    @GET("get_all_countries")
//    Call<CountriesModel> getAllCounries();
//
//    // languages fragment api requests
//    @GET("get_all_languages")
//    Call<AllLanguagesModel> getAllLanguages();
//
//
//
//    @FormUrlEncoded
//    @POST("get_user_language")
//    Call<UserLanguagesModel> getUserLanguages(@Field("user_id") String userId);
//
    @FormUrlEncoded
    @POST("get_user_dependent")
    Call<UserDependentsModel> getUserDependents(@Field("user_id") String userId);

    @FormUrlEncoded
    @POST("user_worker_insert_dependents")
    Call<UserWorkerInsertModel> setNewDependents(@Field("user_sn") String userSn, @Field("dependent_sn") String dependentSn);

    @FormUrlEncoded
    @POST("get_user_health_status")
    Call<UserHealthStatusModel> getUserHealthStauts(@Field("user_id") String userId);

    @FormUrlEncoded
    @POST("get_user_educational_status")
    Call<EducationalStatusModel> getEducationlStatus(@Field("user_id") String userId);

    // user files calls ////////////////////////////////////////////////////////////////

    //career
    @FormUrlEncoded
    @POST("get_user_career")
    Call<UserCareerModel> getUserCareers(@Field("user_id") String userId);

    //work experience
    @FormUrlEncoded
    @POST("get_user_work_experience")
    Call<UserWorkExperienceModel> getUserWorkExperiences(@Field("user_id") String userId);

    // languages
    @GET("get_all_languages")
    Call<AllLanguagesModel> getAllLanguages();

    @FormUrlEncoded
    @POST("get_user_language")
    Call<UserLanguagesModel> getUserLanguages(@Field("user_id") String userId);

    //work status
    @GET("get_work_status")
    Call<WorkStatusModel> getWorkStatus();

    @FormUrlEncoded
    @POST("user_work_status_get_by_user_id")
    Call<PracticalStatusModel> getUserPracticalStatus(@Field("USER_WORK_USER_ID") String userId);

    //training skills
    @FormUrlEncoded
    @POST("get_user_skills_need")
    Call<TrainingSkillsModel> getTrainingSkills(@Field("user_id") String userId);

    //end of user files calls ////////////////////////////////////////////////////////

    @POST("construction_change_place")
    Call<MoveFacilityModel> CheangePlace(@Body RequestBody requestBody);

    @GET("get_all_municipality")
    Call<MunicipalityGroup> getAllMunicipality();


    @GET("get_all_regions?=")
    Call<RegionGroup> getAllregions();

    @GET("get_all_streets")
    Call<StreetGroup> getAllStreets();

    @GET("get_construct_by_num?construct_num=")
    Call<ConstructionGroup> getDataConstruction(@Query("construct_num") String nu_construction);

}
