
package com.sh.wm.ministry.featuers.userfile.workexperience.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserWorkExperience {

    @SerializedName("USER_WORK_EXP_ID")
    @Expose
    private String uSERWORKEXPID;
    @SerializedName("USER_WORK_EXP_USER_ID")
    @Expose
    private String uSERWORKEXPUSERID;
    @SerializedName("USER_WORK_EXP_EXP_TYPE_ID")
    @Expose
    private String uSERWORKEXPEXPTYPEID;
    @SerializedName("USER_WORK_EXP_JOB_TITLE_ID")
    @Expose
    private String uSERWORKEXPJOBTITLEID;
    @SerializedName("USER_WORK_EXP_INSTIT_ID")
    @Expose
    private String uSERWORKEXPINSTITID;
    @SerializedName("USER_WORK_EXP_START_WORK")
    @Expose
    private String uSERWORKEXPSTARTWORK;
    @SerializedName("USER_WORK_EXP_END_WORK")
    @Expose
    private String uSERWORKEXPENDWORK;
    @SerializedName("USER_WORK_OUT_COUNTRY_ID")
    @Expose
    private Object uSERWORKOUTCOUNTRYID;
    @SerializedName("USER_WORK_OUT_START_WORK")
    @Expose
    private Object uSERWORKOUTSTARTWORK;
    @SerializedName("USER_WORK_OUT_END_WORK")
    @Expose
    private Object uSERWORKOUTENDWORK;
    @SerializedName("USER_WORK_OUT_JOB_TITLE_ID")
    @Expose
    private Object uSERWORKOUTJOBTITLEID;
    @SerializedName("INSERT_USER_SN")
    @Expose
    private String iNSERTUSERSN;
    @SerializedName("INSERT_DATE")
    @Expose
    private String iNSERTDATE;
    @SerializedName("UPDATE_USER_SN")
    @Expose
    private String uPDATEUSERSN;
    @SerializedName("UPDATE_DATE")
    @Expose
    private Object uPDATEDATE;
    @SerializedName("IS_DELETE")
    @Expose
    private String iSDELETE;
    @SerializedName("USER_WORK_EXP_LEAVING_REASON")
    @Expose
    private String uSERWORKEXPLEAVINGREASON;
    @SerializedName("PROJECT_ID")
    @Expose
    private Object pROJECTID;
    @SerializedName("CONSTRUCT_ID")
    @Expose
    private String cONSTRUCTID;
    @SerializedName("IS_DEPEND")
    @Expose
    private String iSDEPEND;
    @SerializedName("EXP_TYPE")
    @Expose
    private String eXPTYPE;
    @SerializedName("JOB_TITL")
    @Expose
    private String jOBTITL;
    @SerializedName("EXP_INSTIT")
    @Expose
    private String eXPINSTIT;
    @SerializedName("OUT_JOB_TITLE")
    @Expose
    private Object oUTJOBTITLE;
    @SerializedName("USER_WORK_EXP_START_WORK_OUT")
    @Expose
    private String uSERWORKEXPSTARTWORKOUT;
    @SerializedName("USER_WORK_EXP_END_WORK_OUT")
    @Expose
    private String uSERWORKEXPENDWORKOUT;

    public String getUSERWORKEXPID() {
        return uSERWORKEXPID;
    }

    public void setUSERWORKEXPID(String uSERWORKEXPID) {
        this.uSERWORKEXPID = uSERWORKEXPID;
    }

    public String getUSERWORKEXPUSERID() {
        return uSERWORKEXPUSERID;
    }

    public void setUSERWORKEXPUSERID(String uSERWORKEXPUSERID) {
        this.uSERWORKEXPUSERID = uSERWORKEXPUSERID;
    }

    public String getUSERWORKEXPEXPTYPEID() {
        return uSERWORKEXPEXPTYPEID;
    }

    public void setUSERWORKEXPEXPTYPEID(String uSERWORKEXPEXPTYPEID) {
        this.uSERWORKEXPEXPTYPEID = uSERWORKEXPEXPTYPEID;
    }

    public String getUSERWORKEXPJOBTITLEID() {
        return uSERWORKEXPJOBTITLEID;
    }

    public void setUSERWORKEXPJOBTITLEID(String uSERWORKEXPJOBTITLEID) {
        this.uSERWORKEXPJOBTITLEID = uSERWORKEXPJOBTITLEID;
    }

    public String getUSERWORKEXPINSTITID() {
        return uSERWORKEXPINSTITID;
    }

    public void setUSERWORKEXPINSTITID(String uSERWORKEXPINSTITID) {
        this.uSERWORKEXPINSTITID = uSERWORKEXPINSTITID;
    }

    public String getUSERWORKEXPSTARTWORK() {
        return uSERWORKEXPSTARTWORK;
    }

    public void setUSERWORKEXPSTARTWORK(String uSERWORKEXPSTARTWORK) {
        this.uSERWORKEXPSTARTWORK = uSERWORKEXPSTARTWORK;
    }

    public String getUSERWORKEXPENDWORK() {
        return uSERWORKEXPENDWORK;
    }

    public void setUSERWORKEXPENDWORK(String uSERWORKEXPENDWORK) {
        this.uSERWORKEXPENDWORK = uSERWORKEXPENDWORK;
    }

    public Object getUSERWORKOUTCOUNTRYID() {
        return uSERWORKOUTCOUNTRYID;
    }

    public void setUSERWORKOUTCOUNTRYID(Object uSERWORKOUTCOUNTRYID) {
        this.uSERWORKOUTCOUNTRYID = uSERWORKOUTCOUNTRYID;
    }

    public Object getUSERWORKOUTSTARTWORK() {
        return uSERWORKOUTSTARTWORK;
    }

    public void setUSERWORKOUTSTARTWORK(Object uSERWORKOUTSTARTWORK) {
        this.uSERWORKOUTSTARTWORK = uSERWORKOUTSTARTWORK;
    }

    public Object getUSERWORKOUTENDWORK() {
        return uSERWORKOUTENDWORK;
    }

    public void setUSERWORKOUTENDWORK(Object uSERWORKOUTENDWORK) {
        this.uSERWORKOUTENDWORK = uSERWORKOUTENDWORK;
    }

    public Object getUSERWORKOUTJOBTITLEID() {
        return uSERWORKOUTJOBTITLEID;
    }

    public void setUSERWORKOUTJOBTITLEID(Object uSERWORKOUTJOBTITLEID) {
        this.uSERWORKOUTJOBTITLEID = uSERWORKOUTJOBTITLEID;
    }

    public String getINSERTUSERSN() {
        return iNSERTUSERSN;
    }

    public void setINSERTUSERSN(String iNSERTUSERSN) {
        this.iNSERTUSERSN = iNSERTUSERSN;
    }

    public String getINSERTDATE() {
        return iNSERTDATE;
    }

    public void setINSERTDATE(String iNSERTDATE) {
        this.iNSERTDATE = iNSERTDATE;
    }

    public String getUPDATEUSERSN() {
        return uPDATEUSERSN;
    }

    public void setUPDATEUSERSN(String uPDATEUSERSN) {
        this.uPDATEUSERSN = uPDATEUSERSN;
    }

    public Object getUPDATEDATE() {
        return uPDATEDATE;
    }

    public void setUPDATEDATE(Object uPDATEDATE) {
        this.uPDATEDATE = uPDATEDATE;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

    public String getUSERWORKEXPLEAVINGREASON() {
        return uSERWORKEXPLEAVINGREASON;
    }

    public void setUSERWORKEXPLEAVINGREASON(String uSERWORKEXPLEAVINGREASON) {
        this.uSERWORKEXPLEAVINGREASON = uSERWORKEXPLEAVINGREASON;
    }

    public Object getPROJECTID() {
        return pROJECTID;
    }

    public void setPROJECTID(Object pROJECTID) {
        this.pROJECTID = pROJECTID;
    }

    public String getCONSTRUCTID() {
        return cONSTRUCTID;
    }

    public void setCONSTRUCTID(String cONSTRUCTID) {
        this.cONSTRUCTID = cONSTRUCTID;
    }

    public String getISDEPEND() {
        return iSDEPEND;
    }

    public void setISDEPEND(String iSDEPEND) {
        this.iSDEPEND = iSDEPEND;
    }

    public String getEXPTYPE() {
        return eXPTYPE;
    }

    public void setEXPTYPE(String eXPTYPE) {
        this.eXPTYPE = eXPTYPE;
    }

    public String getJOBTITL() {
        return jOBTITL;
    }

    public void setJOBTITL(String jOBTITL) {
        this.jOBTITL = jOBTITL;
    }

    public String getEXPINSTIT() {
        return eXPINSTIT;
    }

    public void setEXPINSTIT(String eXPINSTIT) {
        this.eXPINSTIT = eXPINSTIT;
    }

    public Object getOUTJOBTITLE() {
        return oUTJOBTITLE;
    }

    public void setOUTJOBTITLE(Object oUTJOBTITLE) {
        this.oUTJOBTITLE = oUTJOBTITLE;
    }

    public String getUSERWORKEXPSTARTWORKOUT() {
        return uSERWORKEXPSTARTWORKOUT;
    }

    public void setUSERWORKEXPSTARTWORKOUT(String uSERWORKEXPSTARTWORKOUT) {
        this.uSERWORKEXPSTARTWORKOUT = uSERWORKEXPSTARTWORKOUT;
    }

    public String getUSERWORKEXPENDWORKOUT() {
        return uSERWORKEXPENDWORKOUT;
    }

    public void setUSERWORKEXPENDWORKOUT(String uSERWORKEXPENDWORKOUT) {
        this.uSERWORKEXPENDWORKOUT = uSERWORKEXPENDWORKOUT;
    }

}
