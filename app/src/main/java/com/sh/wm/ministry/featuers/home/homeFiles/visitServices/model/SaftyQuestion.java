package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;
//generated class for "get_safty_questions_by_subjectid"
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity (tableName = "pal_laws")
public class SaftyQuestion {
    @SerializedName("PAL_LAW_SUBJECT_ID")
    @Expose
    private int palLawSubjectID;

    @SerializedName("PAL_LAW_ARTICAL_DESC")
    @Expose
    private String palLawArticalDesc;
    @SerializedName("PAL_LAW_ARTICAL_NUM")
    @Expose
    private String palLawArticalNum;
    @PrimaryKey
    @NonNull
    @SerializedName("PAL_LAW_ARTICAL_CODE")
    @Expose
    private String palLawArticalCode;

    public String getPalLawArticalDesc() {
        return palLawArticalDesc;
    }

    public void setPalLawArticalDesc(String pal_law_artical_desc) {
        this.palLawArticalDesc = pal_law_artical_desc;
    }

    public String getPalLawArticalNum() {
        return palLawArticalNum;
    }

    public void setPalLawArticalNum(String pALLAWARTICALNUM) {
        this.palLawArticalNum = pALLAWARTICALNUM;
    }

    public String getPalLawArticalCode() {
        return palLawArticalCode;
    }

    public void setPalLawArticalCode(String pALLAWARTICALCODE) {
        this.palLawArticalCode = pALLAWARTICALCODE;
    }

    public int getPalLawSubjectID() {
        return palLawSubjectID;
    }

    public void setPalLawSubjectID(int palLawSubjectID) {
        this.palLawSubjectID = palLawSubjectID;
    }
}
