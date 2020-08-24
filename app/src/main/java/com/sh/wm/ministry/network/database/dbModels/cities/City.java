
package com.sh.wm.ministry.network.database.dbModels.cities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "cities_table")
public class City {

    @PrimaryKey
    @NonNull
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
