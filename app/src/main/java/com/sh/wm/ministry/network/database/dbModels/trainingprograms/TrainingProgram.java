
package com.sh.wm.ministry.network.database.dbModels.trainingprograms;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "training_programs_table")
public class TrainingProgram {

    @PrimaryKey
    @NonNull
    @SerializedName("TRAINING_PROGRAM_ID")
    @Expose
    private String tRAININGPROGRAMID;
    @SerializedName("TRAINING_PROGRAM_AR_NAME")
    @Expose
    private String tRAININGPROGRAMARNAME;
    @SerializedName("TRAINING_PROGRAM_EN_NAME")
    @Expose
    private Object tRAININGPROGRAMENNAME;
    @SerializedName("ISDELETE")
    @Expose
    private String iSDELETE;

    public String getTRAININGPROGRAMID() {
        return tRAININGPROGRAMID;
    }

    public void setTRAININGPROGRAMID(String tRAININGPROGRAMID) {
        this.tRAININGPROGRAMID = tRAININGPROGRAMID;
    }

    public String getTRAININGPROGRAMARNAME() {
        return tRAININGPROGRAMARNAME;
    }

    public void setTRAININGPROGRAMARNAME(String tRAININGPROGRAMARNAME) {
        this.tRAININGPROGRAMARNAME = tRAININGPROGRAMARNAME;
    }

    public Object getTRAININGPROGRAMENNAME() {
        return tRAININGPROGRAMENNAME;
    }

    public void setTRAININGPROGRAMENNAME(Object tRAININGPROGRAMENNAME) {
        this.tRAININGPROGRAMENNAME = tRAININGPROGRAMENNAME;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

}
