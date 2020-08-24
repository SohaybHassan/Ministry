
package com.sh.wm.ministry.network.database.dbModels.cities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("REGION_ID")
    @Expose
    private String rEGIONID;
    @SerializedName("REGION_NAME_AR")
    @Expose
    private String rEGIONNAMEAR;

    public String getREGIONID() {
        return rEGIONID;
    }

    public void setREGIONID(String rEGIONID) {
        this.rEGIONID = rEGIONID;
    }

    public String getREGIONNAMEAR() {
        return rEGIONNAMEAR;
    }

    public void setREGIONNAMEAR(String rEGIONNAMEAR) {
        this.rEGIONNAMEAR = rEGIONNAMEAR;
    }

}
