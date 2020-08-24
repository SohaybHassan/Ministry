
package com.sh.wm.ministry.network.database.dbModels.jobs;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "jobs_table")
public class Job {

    @PrimaryKey
    @NonNull
    @SerializedName("JOB_ID")
    @Expose
    private String jOBID;
    @SerializedName("JOB_AR_NAME")
    @Expose
    private String jOBARNAME;
    @SerializedName("JOB_EN_NAME")
    @Expose
    private Object jOBENNAME;
    @SerializedName("ISDELETE")
    @Expose
    private String iSDELETE;
    @SerializedName("JOB_TRI_CODE")
    @Expose
    private Object jOBTRICODE;
    @SerializedName("INSERT_USER")
    @Expose
    private String iNSERTUSER;
    @SerializedName("INSERT_DATE")
    @Expose
    private Object iNSERTDATE;
    @SerializedName("UPDATE_USER")
    @Expose
    private String uPDATEUSER;
    @SerializedName("UPDATE_DATE")
    @Expose
    private Object uPDATEDATE;
    @SerializedName("JOB_ID_OLD")
    @Expose
    private String jOBIDOLD;

    public String getJOBID() {
        return jOBID;
    }

    public void setJOBID(String jOBID) {
        this.jOBID = jOBID;
    }

    public String getJOBARNAME() {
        return jOBARNAME;
    }

    public void setJOBARNAME(String jOBARNAME) {
        this.jOBARNAME = jOBARNAME;
    }

    public Object getJOBENNAME() {
        return jOBENNAME;
    }

    public void setJOBENNAME(Object jOBENNAME) {
        this.jOBENNAME = jOBENNAME;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

    public Object getJOBTRICODE() {
        return jOBTRICODE;
    }

    public void setJOBTRICODE(Object jOBTRICODE) {
        this.jOBTRICODE = jOBTRICODE;
    }

    public String getINSERTUSER() {
        return iNSERTUSER;
    }

    public void setINSERTUSER(String iNSERTUSER) {
        this.iNSERTUSER = iNSERTUSER;
    }

    public Object getINSERTDATE() {
        return iNSERTDATE;
    }

    public void setINSERTDATE(Object iNSERTDATE) {
        this.iNSERTDATE = iNSERTDATE;
    }

    public String getUPDATEUSER() {
        return uPDATEUSER;
    }

    public void setUPDATEUSER(String uPDATEUSER) {
        this.uPDATEUSER = uPDATEUSER;
    }

    public Object getUPDATEDATE() {
        return uPDATEDATE;
    }

    public void setUPDATEDATE(Object uPDATEDATE) {
        this.uPDATEDATE = uPDATEDATE;
    }

    public String getJOBIDOLD() {
        return jOBIDOLD;
    }

    public void setJOBIDOLD(String jOBIDOLD) {
        this.jOBIDOLD = jOBIDOLD;
    }

}
