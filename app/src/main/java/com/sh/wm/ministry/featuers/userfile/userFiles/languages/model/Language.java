
package com.sh.wm.ministry.featuers.userfile.userFiles.languages.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "languages_table")
public class Language {

    @PrimaryKey
    @NonNull
    @SerializedName("LANGUAGE_ID")
    @Expose
    private String lANGUAGEID;
    @SerializedName("LANGUAGE_AR_NAME")
    @Expose
    private String lANGUAGEARNAME;
    @SerializedName("LANGUAGE_EN_NAME")
    @Expose
    private Object lANGUAGEENNAME;
    @SerializedName("ISDELETE")
    @Expose
    private String iSDELETE;

    public String getLANGUAGEID() {
        return lANGUAGEID;
    }

    public void setLANGUAGEID(String lANGUAGEID) {
        this.lANGUAGEID = lANGUAGEID;
    }

    public String getLANGUAGEARNAME() {
        return lANGUAGEARNAME;
    }

    public void setLANGUAGEARNAME(String lANGUAGEARNAME) {
        this.lANGUAGEARNAME = lANGUAGEARNAME;
    }

    public Object getLANGUAGEENNAME() {
        return lANGUAGEENNAME;
    }

    public void setLANGUAGEENNAME(Object lANGUAGEENNAME) {
        this.lANGUAGEENNAME = lANGUAGEENNAME;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

}
