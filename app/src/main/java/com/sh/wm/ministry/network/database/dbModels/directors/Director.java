
package com.sh.wm.ministry.network.database.dbModels.directors;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "directors_table")
public class Director {

    @PrimaryKey
    @NonNull
    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("NAME")
    @Expose
    private String nAME;
    @SerializedName("ISDELETE")
    @Expose
    private String iSDELETE;
    @SerializedName("OLD")
    @Expose
    private String oLD;
    @SerializedName("CONST_ID")
    @Expose
    private String cONSTID;

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getNAME() {
        return nAME;
    }

    public void setNAME(String nAME) {
        this.nAME = nAME;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

    public String getOLD() {
        return oLD;
    }

    public void setOLD(String oLD) {
        this.oLD = oLD;
    }

    public String getCONSTID() {
        return cONSTID;
    }

    public void setCONSTID(String cONSTID) {
        this.cONSTID = cONSTID;
    }

}
