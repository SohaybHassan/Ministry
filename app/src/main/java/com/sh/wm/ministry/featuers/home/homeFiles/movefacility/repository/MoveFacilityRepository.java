package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.Construction;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.ConstructionGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.MunicipalityGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.PoastDataMoveFacility;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.RegionGroup;
import com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model.StreetGroup;
import com.sh.wm.ministry.network.model.SharedPreferneceHelper;
import com.sh.wm.ministry.network.utiels.NetworkUtils;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoveFacilityRepository {

    private MutableLiveData<MunicipalityGroup> municipalityMutableLiveData;
    private MutableLiveData<RegionGroup> regionMutableLiveData;
    private MutableLiveData<StreetGroup> streetMutableLiveData;
    private MutableLiveData<Construction> constructionMutableLiveData;
    private MutableLiveData<PoastDataMoveFacility> poastDataMoveFacilityMutableLiveData;
    private NetworkUtils networkUtils;
    private Application application;
    private static MoveFacilityRepository mInstance;
    public static final String TAG = MoveFacilityRepository.class.getSimpleName();

    private MoveFacilityRepository(Application application) {

        this.application = application;
        networkUtils = NetworkUtils.getInstance(true, application);
        municipalityMutableLiveData = new MutableLiveData<>();
        regionMutableLiveData = new MutableLiveData<>();
        streetMutableLiveData = new MutableLiveData<>();
        constructionMutableLiveData = new MutableLiveData<>();
        poastDataMoveFacilityMutableLiveData = new MutableLiveData<>();
    }

    public static MoveFacilityRepository getInstance(Application application) {
        if (mInstance == null) {
            mInstance = new MoveFacilityRepository(application);

        }
        return mInstance;
    }

    public LiveData<MunicipalityGroup> getAllMunicipality() {
        Log.d(TAG, "getAllMunicipality: " + "sohaib hassan");
        Call<MunicipalityGroup> call = networkUtils.getApiInterface().getAllMunicipality();
        call.enqueue(new Callback<MunicipalityGroup>() {
            @Override
            public void onResponse(@NotNull Call<MunicipalityGroup> call, @NotNull Response<MunicipalityGroup> response) {

                Log.d(TAG, "onResponse token: " + SharedPreferneceHelper.getToken(application));
                if (response.body() != null) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse: " + response.body().toString());
                        municipalityMutableLiveData.postValue(response.body());

                    } else {
                        municipalityMutableLiveData.postValue(null);

                    }
                } else {
                    Log.d(TAG, "onResponse:  no data receved");
                }
            }

            @Override
            public void onFailure(Call<MunicipalityGroup> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());

                municipalityMutableLiveData.postValue(null);
            }
        });

        return municipalityMutableLiveData;
    }


    public LiveData<RegionGroup> getAllRegion() {
        Call<RegionGroup> call = networkUtils.getApiInterface().getAllregions();
        call.enqueue(new Callback<RegionGroup>() {
            @Override
            public void onResponse(Call<RegionGroup> call, Response<RegionGroup> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse:  getAll data" + response.body().toString());
                    regionMutableLiveData.postValue(response.body());
                } else {
                    regionMutableLiveData.setValue(null);
                    Log.d(TAG, "onResponse:  I cant see any data" + response.message());
                }
            }

            @Override
            public void onFailure(Call<RegionGroup> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                regionMutableLiveData.setValue(null);
            }
        });
        return regionMutableLiveData;
    }


    public LiveData<StreetGroup> getAllStreet() {
        Call<StreetGroup> call = networkUtils.getApiInterface().getAllStreets();
        call.enqueue(new Callback<StreetGroup>() {
            @Override
            public void onResponse(Call<StreetGroup> call, Response<StreetGroup> response) {
                if (response.isSuccessful()) {

                    Log.d(TAG, "onResponse: " + response.body().getStreets().get(1).getSTREETID());

                }
                streetMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<StreetGroup> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return streetMutableLiveData;
    }

    public LiveData<Construction> getConstructiondata(String num_construction) {
        Call<ConstructionGroup> call = networkUtils.getApiInterface().getDataConstruction(num_construction);
        call.enqueue(new Callback<ConstructionGroup>() {
            @Override
            public void onResponse(@NotNull Call<ConstructionGroup> call, @NotNull Response<ConstructionGroup> response) {

                if (response.body().getStatus() != 1) {
                    if (response.isSuccessful()) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<Construction>() {
                        }.getType();
                        // assert response.body() != null;
                        Construction construction = gson.fromJson(gson.toJson(response.body().getConstruction()), type);
                        Log.d(TAG, "onResponse: sh " + construction.getCONSTRUCTNUM());
                        Log.d(TAG, "onResponse: sh " + response.body().toString());

                        constructionMutableLiveData.setValue(response.body().getConstruction());
                    } else {
                        Log.d(TAG, "onResponse: no data her");
                        constructionMutableLiveData.setValue(null);
                    }
                } else {
                    Log.d(TAG, "onResponse: null data her");
                    constructionMutableLiveData.setValue(null);

                }
            }

            @Override
            public void onFailure(@NotNull Call<ConstructionGroup> call, @NotNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                constructionMutableLiveData.setValue(null);
            }
        });
        return constructionMutableLiveData;

    }

    public LiveData<PoastDataMoveFacility> postdata(String cnstruction_id, String address_id, String municipapiity_id, String region_id,
                                                    String street_id, String bulding_no, String address_desc, String x_direction, String y_direction,
                                                    String construction_tele, String construction_mobile, String construction_fax, String construction_box,
                                                    String construction_url) {
//        JsonObject req = new JsonObject();
//        req.addProperty("cnstruction_id", cnstruction_id);
//        req.addProperty("address_id", address_id);
//        req.addProperty("municipapiity_id", municipapiity_id);
//        req.addProperty("region_id", region_id);
//        req.addProperty("street_id", street_id);
//        req.addProperty("bulding_no", bulding_no);
//        req.addProperty("address_desc", address_desc);
//        req.addProperty("x_direction", x_direction);
//        req.addProperty("y_direction", y_direction);
//        req.addProperty("construction_tele", construction_tele);
//        req.addProperty("construction_mobile", construction_mobile);
//        req.addProperty("construction_fax", construction_fax);
//        req.addProperty("construction_box", construction_box);
//        req.addProperty("construction_url", construction_url);
//
//        RequestBody requestBody = RequestBody.create(String.valueOf(req), MediaType.parse("application/json"));


        Call<PoastDataMoveFacility> call = networkUtils.getApiInterface().CheangePlace(cnstruction_id,address_id,municipapiity_id,region_id,street_id,bulding_no,address_desc,x_direction,y_direction,construction_tele,construction_mobile,construction_fax,construction_box,construction_url);
        call.enqueue(new Callback<PoastDataMoveFacility>() {
            @Override
            public void onResponse(Call<PoastDataMoveFacility> call, Response<PoastDataMoveFacility> response) {

                if (response.isSuccessful()) {

                    Log.d(TAG, "onResponse: ' " + response.body().getMessageText());

                    poastDataMoveFacilityMutableLiveData.setValue(response.body());
                } else {
                    Log.d(TAG, "onResponse: '  Failure");
                    poastDataMoveFacilityMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<PoastDataMoveFacility> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                poastDataMoveFacilityMutableLiveData.setValue(null);
            }
        });
        return poastDataMoveFacilityMutableLiveData;

    }


}
