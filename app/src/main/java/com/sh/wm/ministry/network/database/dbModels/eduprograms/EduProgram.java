
package com.sh.wm.ministry.network.database.dbModels.eduprograms;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "edu_programs_table")
public class EduProgram {

    @PrimaryKey
    @NonNull
    @SerializedName("PROG_CD")
    @Expose
    private String pROGCD;
    @SerializedName("PROG_DESC")
    @Expose
    private String pROGDESC;
    @SerializedName("ISDELETE")
    @Expose
    private String iSDELETE;

    public String getPROGCD() {
        return pROGCD;
    }

    public void setPROGCD(String pROGCD) {
        this.pROGCD = pROGCD;
    }

    public String getPROGDESC() {
        return pROGDESC;
    }

    public void setPROGDESC(String pROGDESC) {
        this.pROGDESC = pROGDESC;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

}
