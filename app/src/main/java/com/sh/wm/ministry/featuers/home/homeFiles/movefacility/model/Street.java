package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Street {

    @SerializedName("STREET_ID")
    @Expose
    private String sTREETID;
    @SerializedName("STREET_NAME_AR")
    @Expose
    private String sTREETNAMEAR;

    public String getSTREETID() {
        return sTREETID;
    }

    public void setSTREETID(String sTREETID) {
        this.sTREETID = sTREETID;
    }

    public String getSTREETNAMEAR() {
        return sTREETNAMEAR;
    }

    public void setSTREETNAMEAR(String sTREETNAMEAR) {
        this.sTREETNAMEAR = sTREETNAMEAR;
    }

}
