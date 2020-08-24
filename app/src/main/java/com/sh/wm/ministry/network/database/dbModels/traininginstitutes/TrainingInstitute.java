
package com.sh.wm.ministry.network.database.dbModels.traininginstitutes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrainingInstitute {

    @SerializedName("TRAIN_INSTITUTES_ID")
    @Expose
    private String tRAININSTITUTESID;
    @SerializedName("TRAIN_INSTITUTES_AR_NAME")
    @Expose
    private String tRAININSTITUTESARNAME;
    @SerializedName("TRAIN_INSTITUTES_EN_NAME")
    @Expose
    private Object tRAININSTITUTESENNAME;
    @SerializedName("ISDELETE")
    @Expose
    private String iSDELETE;

    public String getTRAININSTITUTESID() {
        return tRAININSTITUTESID;
    }

    public void setTRAININSTITUTESID(String tRAININSTITUTESID) {
        this.tRAININSTITUTESID = tRAININSTITUTESID;
    }

    public String getTRAININSTITUTESARNAME() {
        return tRAININSTITUTESARNAME;
    }

    public void setTRAININSTITUTESARNAME(String tRAININSTITUTESARNAME) {
        this.tRAININSTITUTESARNAME = tRAININSTITUTESARNAME;
    }

    public Object getTRAININSTITUTESENNAME() {
        return tRAININSTITUTESENNAME;
    }

    public void setTRAININSTITUTESENNAME(Object tRAININSTITUTESENNAME) {
        this.tRAININSTITUTESENNAME = tRAININSTITUTESENNAME;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

}
