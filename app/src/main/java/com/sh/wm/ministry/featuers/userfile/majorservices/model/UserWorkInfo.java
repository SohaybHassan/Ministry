
package com.sh.wm.ministry.featuers.userfile.majorservices.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserWorkInfo {

    @SerializedName("USER_ID")
    @Expose
    private String uSERID;
    @SerializedName("USER_DOCS_TYPE")
    @Expose
    private String uSERDOCSTYPE;
    @SerializedName("USER_DOCS_TYPE_ID")
    @Expose
    private String uSERDOCSTYPEID;
    @SerializedName("USER_SN")
    @Expose
    private String uSERSN;
    @SerializedName("USER_AGE")
    @Expose
    private String uSERAGE;
    @SerializedName("USER_F_NAME_AR")
    @Expose
    private String uSERFNAMEAR;
    @SerializedName("USER_S_NAME_AR")
    @Expose
    private String uSERSNAMEAR;
    @SerializedName("USER_T_NAME_AR")
    @Expose
    private String uSERTNAMEAR;
    @SerializedName("USER_L_NAME_AR")
    @Expose
    private String uSERLNAMEAR;
    @SerializedName("WORKER_FULL_NAME")
    @Expose
    private String wORKERFULLNAME;
    @SerializedName("USER_SEX")
    @Expose
    private String uSERSEX;
    @SerializedName("BIRTH_PLACE")
    @Expose
    private String bIRTHPLACE;
    @SerializedName("BRITH_DATE")
    @Expose
    private String bRITHDATE;
    @SerializedName("USER_MOTHER_NAME")
    @Expose
    private String uSERMOTHERNAME;
    @SerializedName("SOCIAL_STATUS")
    @Expose
    private String sOCIALSTATUS;
    @SerializedName("USER_CHIDED_NUM")
    @Expose
    private String uSERCHIDEDNUM;
    @SerializedName("USER_DEATH_DATE")
    @Expose
    private Object uSERDEATHDATE;
    @SerializedName("USER_NATIONALITY_ID")
    @Expose
    private String uSERNATIONALITYID;
    @SerializedName("USER_NATIONALITY_OTHER_ID")
    @Expose
    private String uSERNATIONALITYOTHERID;
    @SerializedName("USER_DIRECTORATE")
    @Expose
    private String uSERDIRECTORATE;

    public String getUSERID() {
        return uSERID;
    }

    public void setUSERID(String uSERID) {
        this.uSERID = uSERID;
    }

    public String getUSERDOCSTYPE() {
        return uSERDOCSTYPE;
    }

    public void setUSERDOCSTYPE(String uSERDOCSTYPE) {
        this.uSERDOCSTYPE = uSERDOCSTYPE;
    }

    public String getUSERDOCSTYPEID() {
        return uSERDOCSTYPEID;
    }

    public void setUSERDOCSTYPEID(String uSERDOCSTYPEID) {
        this.uSERDOCSTYPEID = uSERDOCSTYPEID;
    }

    public String getUSERSN() {
        return uSERSN;
    }

    public void setUSERSN(String uSERSN) {
        this.uSERSN = uSERSN;
    }

    public String getUSERAGE() {
        return uSERAGE;
    }

    public void setUSERAGE(String uSERAGE) {
        this.uSERAGE = uSERAGE;
    }

    public String getUSERFNAMEAR() {
        return uSERFNAMEAR;
    }

    public void setUSERFNAMEAR(String uSERFNAMEAR) {
        this.uSERFNAMEAR = uSERFNAMEAR;
    }

    public String getUSERSNAMEAR() {
        return uSERSNAMEAR;
    }

    public void setUSERSNAMEAR(String uSERSNAMEAR) {
        this.uSERSNAMEAR = uSERSNAMEAR;
    }

    public String getUSERTNAMEAR() {
        return uSERTNAMEAR;
    }

    public void setUSERTNAMEAR(String uSERTNAMEAR) {
        this.uSERTNAMEAR = uSERTNAMEAR;
    }

    public String getUSERLNAMEAR() {
        return uSERLNAMEAR;
    }

    public void setUSERLNAMEAR(String uSERLNAMEAR) {
        this.uSERLNAMEAR = uSERLNAMEAR;
    }

    public String getWORKERFULLNAME() {
        return wORKERFULLNAME;
    }

    public void setWORKERFULLNAME(String wORKERFULLNAME) {
        this.wORKERFULLNAME = wORKERFULLNAME;
    }

    public String getUSERSEX() {
        return uSERSEX;
    }

    public void setUSERSEX(String uSERSEX) {
        this.uSERSEX = uSERSEX;
    }

    public String getBIRTHPLACE() {
        return bIRTHPLACE;
    }

    public void setBIRTHPLACE(String bIRTHPLACE) {
        this.bIRTHPLACE = bIRTHPLACE;
    }

    public String getBRITHDATE() {
        return bRITHDATE;
    }

    public void setBRITHDATE(String bRITHDATE) {
        this.bRITHDATE = bRITHDATE;
    }

    public String getUSERMOTHERNAME() {
        return uSERMOTHERNAME;
    }

    public void setUSERMOTHERNAME(String uSERMOTHERNAME) {
        this.uSERMOTHERNAME = uSERMOTHERNAME;
    }

    public String getSOCIALSTATUS() {
        return sOCIALSTATUS;
    }

    public void setSOCIALSTATUS(String sOCIALSTATUS) {
        this.sOCIALSTATUS = sOCIALSTATUS;
    }

    public String getUSERCHIDEDNUM() {
        return uSERCHIDEDNUM;
    }

    public void setUSERCHIDEDNUM(String uSERCHIDEDNUM) {
        this.uSERCHIDEDNUM = uSERCHIDEDNUM;
    }

    public Object getUSERDEATHDATE() {
        return uSERDEATHDATE;
    }

    public void setUSERDEATHDATE(Object uSERDEATHDATE) {
        this.uSERDEATHDATE = uSERDEATHDATE;
    }

    public String getUSERNATIONALITYID() {
        return uSERNATIONALITYID;
    }

    public void setUSERNATIONALITYID(String uSERNATIONALITYID) {
        this.uSERNATIONALITYID = uSERNATIONALITYID;
    }

    public String getUSERNATIONALITYOTHERID() {
        return uSERNATIONALITYOTHERID;
    }

    public void setUSERNATIONALITYOTHERID(String uSERNATIONALITYOTHERID) {
        this.uSERNATIONALITYOTHERID = uSERNATIONALITYOTHERID;
    }

    public String getUSERDIRECTORATE() {
        return uSERDIRECTORATE;
    }

    public void setUSERDIRECTORATE(String uSERDIRECTORATE) {
        this.uSERDIRECTORATE = uSERDIRECTORATE;
    }

}
