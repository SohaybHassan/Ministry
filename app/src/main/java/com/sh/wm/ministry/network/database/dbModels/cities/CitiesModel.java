
package com.sh.wm.ministry.network.database.dbModels.cities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CitiesModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("cities")
    @Expose
    private List<City> cities = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

}
