package com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserQayedArchive {
    @SerializedName("QAYED_ID")
    @Expose
    private String qAYEDID;
    @SerializedName("QAYED_USER_ID")
    @Expose
    private String qAYEDUSERID;
    @SerializedName("QAYED_STATUS")
    @Expose
    private String qAYEDSTATUS;
    @SerializedName("QAYED_DATE")
    @Expose
    private String qAYEDDATE;
    @SerializedName("IS_DELETE")
    @Expose
    private String iSDELETE;
    @SerializedName("IS_ACTIVE")
    @Expose
    private String iSACTIVE;
    @SerializedName("INSERT_DATE")
    @Expose
    private String iNSERTDATE;
    @SerializedName("INSERT_USER_SN")
    @Expose
    private String iNSERTUSERSN;
    @SerializedName("UPDATE_DATE")
    @Expose
    private String uPDATEDATE;
    @SerializedName("UPDATE_USER_SN")
    @Expose
    private String uPDATEUSERSN;
    @SerializedName("QAYED_WORK_STATUS_ID")
    @Expose
    private String qAYEDWORKSTATUSID;
    @SerializedName("QAYED_WORK_STATUS_DESC_ID")
    @Expose
    private String qAYEDWORKSTATUSDESCID;
    @SerializedName("QAYED_DESC_DESC_ID")
    @Expose
    private String qAYEDDESCDESCID;
    @SerializedName("WORKER_NAME")
    @Expose
    private String wORKERNAME;
    @SerializedName("WORK_STATUS_DESC")
    @Expose
    private String wORKSTATUSDESC;
    @SerializedName("WORK_STATUS_DESC_DESC")
    @Expose
    private String wORKSTATUSDESCDESC;
    @SerializedName("STATUS")
    @Expose
    private String sTATUS;

    public String getQAYEDID() {
        return qAYEDID;
    }

    public void setQAYEDID(String qAYEDID) {
        this.qAYEDID = qAYEDID;
    }

    public String getQAYEDUSERID() {
        return qAYEDUSERID;
    }

    public void setQAYEDUSERID(String qAYEDUSERID) {
        this.qAYEDUSERID = qAYEDUSERID;
    }

    public String getQAYEDSTATUS() {
        return qAYEDSTATUS;
    }

    public void setQAYEDSTATUS(String qAYEDSTATUS) {
        this.qAYEDSTATUS = qAYEDSTATUS;
    }

    public String getQAYEDDATE() {
        return qAYEDDATE;
    }

    public void setQAYEDDATE(String qAYEDDATE) {
        this.qAYEDDATE = qAYEDDATE;
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

    public String getINSERTDATE() {
        return iNSERTDATE;
    }

    public void setINSERTDATE(String iNSERTDATE) {
        this.iNSERTDATE = iNSERTDATE;
    }

    public String getINSERTUSERSN() {
        return iNSERTUSERSN;
    }

    public void setINSERTUSERSN(String iNSERTUSERSN) {
        this.iNSERTUSERSN = iNSERTUSERSN;
    }

    public String getUPDATEDATE() {
        return uPDATEDATE;
    }

    public void setUPDATEDATE(String uPDATEDATE) {
        this.uPDATEDATE = uPDATEDATE;
    }

    public String getUPDATEUSERSN() {
        return uPDATEUSERSN;
    }

    public void setUPDATEUSERSN(String uPDATEUSERSN) {
        this.uPDATEUSERSN = uPDATEUSERSN;
    }

    public String getQAYEDWORKSTATUSID() {
        return qAYEDWORKSTATUSID;
    }

    public void setQAYEDWORKSTATUSID(String qAYEDWORKSTATUSID) {
        this.qAYEDWORKSTATUSID = qAYEDWORKSTATUSID;
    }

    public String getQAYEDWORKSTATUSDESCID() {
        return qAYEDWORKSTATUSDESCID;
    }

    public void setQAYEDWORKSTATUSDESCID(String qAYEDWORKSTATUSDESCID) {
        this.qAYEDWORKSTATUSDESCID = qAYEDWORKSTATUSDESCID;
    }

    public String getQAYEDDESCDESCID() {
        return qAYEDDESCDESCID;
    }

    public void setQAYEDDESCDESCID(String qAYEDDESCDESCID) {
        this.qAYEDDESCDESCID = qAYEDDESCDESCID;
    }

    public String getWORKERNAME() {
        return wORKERNAME;
    }

    public void setWORKERNAME(String wORKERNAME) {
        this.wORKERNAME = wORKERNAME;
    }

    public String getWORKSTATUSDESC() {
        return wORKSTATUSDESC;
    }

    public void setWORKSTATUSDESC(String wORKSTATUSDESC) {
        this.wORKSTATUSDESC = wORKSTATUSDESC;
    }

    public String getWORKSTATUSDESCDESC() {
        return wORKSTATUSDESCDESC;
    }

    public void setWORKSTATUSDESCDESC(String wORKSTATUSDESCDESC) {
        this.wORKSTATUSDESCDESC = wORKSTATUSDESCDESC;
    }

    public String getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }
}
