
package com.sh.wm.ministry.network.database.dbModels.educationalinstitutes;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "educational_institutes_table")
public class EducationalInstitute {

    @PrimaryKey
    @NonNull
    @SerializedName("EDU_INSTITUTES_ID")
    @Expose
    private String eDUINSTITUTESID;
    @SerializedName("EDU_INSTITUTES_AR_NAME")
    @Expose
    private String eDUINSTITUTESARNAME;
    @SerializedName("EDU_INSTITUTES_EN_NAME")
    @Expose
    private Object eDUINSTITUTESENNAME;
    @SerializedName("EDU_INSTITUTES_COUNTRY")
    @Expose
    private String eDUINSTITUTESCOUNTRY;

    public String getEDUINSTITUTESID() {
        return eDUINSTITUTESID;
    }

    public void setEDUINSTITUTESID(String eDUINSTITUTESID) {
        this.eDUINSTITUTESID = eDUINSTITUTESID;
    }

    public String getEDUINSTITUTESARNAME() {
        return eDUINSTITUTESARNAME;
    }

    public void setEDUINSTITUTESARNAME(String eDUINSTITUTESARNAME) {
        this.eDUINSTITUTESARNAME = eDUINSTITUTESARNAME;
    }

    public Object getEDUINSTITUTESENNAME() {
        return eDUINSTITUTESENNAME;
    }

    public void setEDUINSTITUTESENNAME(Object eDUINSTITUTESENNAME) {
        this.eDUINSTITUTESENNAME = eDUINSTITUTESENNAME;
    }

    public String getEDUINSTITUTESCOUNTRY() {
        return eDUINSTITUTESCOUNTRY;
    }

    public void setEDUINSTITUTESCOUNTRY(String eDUINSTITUTESCOUNTRY) {
        this.eDUINSTITUTESCOUNTRY = eDUINSTITUTESCOUNTRY;
    }

}
