
package com.sh.wm.ministry.featuers.userfile.practicalstatus.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "work_status_table")
public class WorkStatus {


    @PrimaryKey
    @NonNull
    @SerializedName("WORK_STATUS_ID")
    @Expose
    private String wORKSTATUSID;
    @SerializedName("WORK_STATUS_NAME")
    @Expose
    private String wORKSTATUSNAME;
    @SerializedName("ISDELETE")
    @Expose
    private String iSDELETE;

    public String getWORKSTATUSID() {
        return wORKSTATUSID;
    }

    public void setWORKSTATUSID(String wORKSTATUSID) {
        this.wORKSTATUSID = wORKSTATUSID;
    }

    public String getWORKSTATUSNAME() {
        return wORKSTATUSNAME;
    }

    public void setWORKSTATUSNAME(String wORKSTATUSNAME) {
        this.wORKSTATUSNAME = wORKSTATUSNAME;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

}
