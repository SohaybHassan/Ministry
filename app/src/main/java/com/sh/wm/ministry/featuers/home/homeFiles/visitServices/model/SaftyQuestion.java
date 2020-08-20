package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;
//{{url}}/get_safty_questions_by_subjectid?SUBJECT_LAW_ID=1
//the generated object
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaftyQuestion {

    @SerializedName("PAL_LAW_ARTICAL_DESC")
    @Expose
    private String pALLAWARTICALDESC;
    @SerializedName("PAL_LAW_ARTICAL_NUM")
    @Expose
    private String pALLAWARTICALNUM;
    @SerializedName("PAL_LAW_ARTICAL_CODE")
    @Expose
    private String pALLAWARTICALCODE;

    public String getPALLAWARTICALDESC() {
        return pALLAWARTICALDESC;
    }

    public void setPALLAWARTICALDESC(String pALLAWARTICALDESC) {
        this.pALLAWARTICALDESC = pALLAWARTICALDESC;
    }

    public String getPALLAWARTICALNUM() {
        return pALLAWARTICALNUM;
    }

    public void setPALLAWARTICALNUM(String pALLAWARTICALNUM) {
        this.pALLAWARTICALNUM = pALLAWARTICALNUM;
    }

    public String getPALLAWARTICALCODE() {
        return pALLAWARTICALCODE;
    }

    public void setPALLAWARTICALCODE(String pALLAWARTICALCODE) {
        this.pALLAWARTICALCODE = pALLAWARTICALCODE;
    }

}