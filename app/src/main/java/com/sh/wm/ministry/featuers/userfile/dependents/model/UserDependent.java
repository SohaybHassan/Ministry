
package com.sh.wm.ministry.featuers.userfile.dependents.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserDependent {

    @SerializedName("USER_DEP_ID")
    @Expose
    private String uSERDEPID;
    @SerializedName("USER_DEP_USER_ID")
    @Expose
    private String uSERDEPUSERID;
    @SerializedName("USER_DEP_FULL_NAME")
    @Expose
    private String uSERDEPFULLNAME;
    @SerializedName("USER_DEP_DOCUMENT_ID")
    @Expose
    private String uSERDEPDOCUMENTID;
    @SerializedName("USER_DEP_WORK_ID")
    @Expose
    private Object uSERDEPWORKID;
    @SerializedName("USER_DEP_RELATIONSHIP")
    @Expose
    private String uSERDEPRELATIONSHIP;
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
    private String uPDATEDATE;
    @SerializedName("IS_DELETE")
    @Expose
    private String iSDELETE;
    @SerializedName("IS_ACTIVE")
    @Expose
    private String iSACTIVE;
    @SerializedName("USER_DEP_BIRTHDATE")
    @Expose
    private String uSERDEPBIRTHDATE;
    @SerializedName("DEP_BIRTHDATE")
    @Expose
    private String dEPBIRTHDATE;
    @SerializedName("RELATIONSHIP")
    @Expose
    private String rELATIONSHIP;

    public String getUSERDEPID() {
        return uSERDEPID;
    }

    public void setUSERDEPID(String uSERDEPID) {
        this.uSERDEPID = uSERDEPID;
    }

    public String getUSERDEPUSERID() {
        return uSERDEPUSERID;
    }

    public void setUSERDEPUSERID(String uSERDEPUSERID) {
        this.uSERDEPUSERID = uSERDEPUSERID;
    }

    public String getUSERDEPFULLNAME() {
        return uSERDEPFULLNAME;
    }

    public void setUSERDEPFULLNAME(String uSERDEPFULLNAME) {
        this.uSERDEPFULLNAME = uSERDEPFULLNAME;
    }

    public String getUSERDEPDOCUMENTID() {
        return uSERDEPDOCUMENTID;
    }

    public void setUSERDEPDOCUMENTID(String uSERDEPDOCUMENTID) {
        this.uSERDEPDOCUMENTID = uSERDEPDOCUMENTID;
    }

    public Object getUSERDEPWORKID() {
        return uSERDEPWORKID;
    }

    public void setUSERDEPWORKID(Object uSERDEPWORKID) {
        this.uSERDEPWORKID = uSERDEPWORKID;
    }

    public String getUSERDEPRELATIONSHIP() {
        return uSERDEPRELATIONSHIP;
    }

    public void setUSERDEPRELATIONSHIP(String uSERDEPRELATIONSHIP) {
        this.uSERDEPRELATIONSHIP = uSERDEPRELATIONSHIP;
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

    public String getUPDATEDATE() {
        return uPDATEDATE;
    }

    public void setUPDATEDATE(String uPDATEDATE) {
        this.uPDATEDATE = uPDATEDATE;
    }

    public String getISDELETE() {
        return iSDELETE;
    }

    public void setISDELETE(String iSDELETE) {
        this.iSDELETE = iSDELETE;
    }

    public String getISACTIVE() {
        return iSACTIVE;
    }

    public void setISACTIVE(String iSACTIVE) {
        this.iSACTIVE = iSACTIVE;
    }

    public String getUSERDEPBIRTHDATE() {
        return uSERDEPBIRTHDATE;
    }

    public void setUSERDEPBIRTHDATE(String uSERDEPBIRTHDATE) {
        this.uSERDEPBIRTHDATE = uSERDEPBIRTHDATE;
    }

    public String getDEPBIRTHDATE() {
        return dEPBIRTHDATE;
    }

    public void setDEPBIRTHDATE(String dEPBIRTHDATE) {
        this.dEPBIRTHDATE = dEPBIRTHDATE;
    }

    public String getRELATIONSHIP() {
        return rELATIONSHIP;
    }

    public void setRELATIONSHIP(String rELATIONSHIP) {
        this.rELATIONSHIP = rELATIONSHIP;
    }

}
