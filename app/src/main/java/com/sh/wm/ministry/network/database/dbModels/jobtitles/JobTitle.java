
package com.sh.wm.ministry.network.database.dbModels.jobtitles;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "job_titles_table")
public class JobTitle {

    @PrimaryKey
    @NonNull
    @SerializedName("JOB_TITLE_ID")
    @Expose
    private String jOBTITLEID;
    @SerializedName("JOB_TITLE_DESC")
    @Expose
    private String jOBTITLEDESC;
    @SerializedName("JOB_TITLE_JOB_ID")
    @Expose
    private Object jOBTITLEJOBID;
    @SerializedName("ISDELETE")
    @Expose
    private String iSDELETE;

    public String getJOBTITLEID() {
        return jOBTITLEID;
    }

    public void setJOBTITLEID(String jOBTITLEID) {
        this.jOBTITLEID = jOBTITLEID;
    }

    public String getJOBTITLEDESC() {
        return jOBTITLEDESC;
    }

    public void setJOBTITLEDESC(String jOBTITLEDESC) {
        this.jOBTITLEDESC = jOBTITLEDESC;
    }

    public Object getJOBTITLEJOBID() {
        return jOBTITLEJOBID;
    }

    public void setJOBTITLEJOBID(Object jOBTITLEJOBID) {
        this.jOBTITLEJOBID = jOBTITLEJOBID;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

}
