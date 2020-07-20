package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegionGroup {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("regions")
    @Expose
    private List<Region> regions = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

}