package com.sh.wm.ministry.network.database.dbModels.muniplicities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MunicipalityModel {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("municipalities")
    @Expose
    private List<Municipality> municipalities = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Municipality> getMunicipalities() {
        return municipalities;
    }

    public void setMunicipalities(List<Municipality> municipalities) {
        this.municipalities = municipalities;
    }

}