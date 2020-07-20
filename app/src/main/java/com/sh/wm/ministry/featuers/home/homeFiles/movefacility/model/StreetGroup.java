package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StreetGroup {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("streets")
    @Expose
    private List<Street> streets = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

}