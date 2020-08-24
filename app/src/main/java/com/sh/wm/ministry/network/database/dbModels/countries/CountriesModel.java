
package com.sh.wm.ministry.network.database.dbModels.countries;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountriesModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("countries")
    @Expose
    private List<Country> countries = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

}
