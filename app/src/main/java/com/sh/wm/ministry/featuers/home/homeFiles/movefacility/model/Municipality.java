package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Municipality {

    @SerializedName("MUNICIPALITY_ID")
    @Expose
    private String mUNICIPALITYID;
    @SerializedName("MUNICIPALITY_NAME_AR")
    @Expose
    private String mUNICIPALITYNAMEAR;
    @SerializedName("DIRECTOR_ID")
    @Expose
    private String dIRECTORID;

    public String getMUNICIPALITYID() {
        return mUNICIPALITYID;
    }

    public void setMUNICIPALITYID(String mUNICIPALITYID) {
        this.mUNICIPALITYID = mUNICIPALITYID;
    }

    public String getMUNICIPALITYNAMEAR() {
        return mUNICIPALITYNAMEAR;
    }

    public void setMUNICIPALITYNAMEAR(String mUNICIPALITYNAMEAR) {
        this.mUNICIPALITYNAMEAR = mUNICIPALITYNAMEAR;
    }

    public String getDIRECTORID() {
        return dIRECTORID;
    }

    public void setDIRECTORID(String dIRECTORID) {
        this.dIRECTORID = dIRECTORID;
    }

}