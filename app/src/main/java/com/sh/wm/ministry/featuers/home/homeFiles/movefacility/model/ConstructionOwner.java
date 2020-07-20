package com.sh.wm.ministry.featuers.home.homeFiles.movefacility.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConstructionOwner {

    @SerializedName("COUNT_ROW")
    @Expose
    private String cOUNTROW;
    @SerializedName("ROW_NUM")
    @Expose
    private String rOWNUM;
    @SerializedName("CONSTRUCT_ID")
    @Expose
    private String cONSTRUCTID;
    @SerializedName("CONSTRUCT_OWNER_ID")
    @Expose
    private String cONSTRUCTOWNERID;
    @SerializedName("CONSTRUCT_USER_ID")
    @Expose
    private String cONSTRUCTUSERID;
    @SerializedName("ISDEPEND")
    @Expose
    private String iSDEPEND;
    @SerializedName("INSERTUSERID")
    @Expose
    private String iNSERTUSERID;
    @SerializedName("INSERTDATE")
    @Expose
    private String iNSERTDATE;
    @SerializedName("UPDATEUSERID")
    @Expose
    private Object uPDATEUSERID;
    @SerializedName("UPDATEDATE")
    @Expose
    private Object uPDATEDATE;
    @SerializedName("USER_SN")
    @Expose
    private String uSERSN;
    @SerializedName("OWNER_NAME")
    @Expose
    private String oWNERNAME;
    @SerializedName("USER_SEX_ID")
    @Expose
    private String uSERSEXID;

    public String getCOUNTROW() {
        return cOUNTROW;
    }

    public void setCOUNTROW(String cOUNTROW) {
        this.cOUNTROW = cOUNTROW;
    }

    public String getROWNUM() {
        return rOWNUM;
    }

    public void setROWNUM(String rOWNUM) {
        this.rOWNUM = rOWNUM;
    }

    public String getCONSTRUCTID() {
        return cONSTRUCTID;
    }

    public void setCONSTRUCTID(String cONSTRUCTID) {
        this.cONSTRUCTID = cONSTRUCTID;
    }

    public String getCONSTRUCTOWNERID() {
        return cONSTRUCTOWNERID;
    }

    public void setCONSTRUCTOWNERID(String cONSTRUCTOWNERID) {
        this.cONSTRUCTOWNERID = cONSTRUCTOWNERID;
    }

    public String getCONSTRUCTUSERID() {
        return cONSTRUCTUSERID;
    }

    public void setCONSTRUCTUSERID(String cONSTRUCTUSERID) {
        this.cONSTRUCTUSERID = cONSTRUCTUSERID;
    }

    public String getISDEPEND() {
        return iSDEPEND;
    }

    public void setISDEPEND(String iSDEPEND) {
        this.iSDEPEND = iSDEPEND;
    }

    public String getINSERTUSERID() {
        return iNSERTUSERID;
    }

    public void setINSERTUSERID(String iNSERTUSERID) {
        this.iNSERTUSERID = iNSERTUSERID;
    }

    public String getINSERTDATE() {
        return iNSERTDATE;
    }

    public void setINSERTDATE(String iNSERTDATE) {
        this.iNSERTDATE = iNSERTDATE;
    }

    public Object getUPDATEUSERID() {
        return uPDATEUSERID;
    }

    public void setUPDATEUSERID(Object uPDATEUSERID) {
        this.uPDATEUSERID = uPDATEUSERID;
    }

    public Object getUPDATEDATE() {
        return uPDATEDATE;
    }

    public void setUPDATEDATE(Object uPDATEDATE) {
        this.uPDATEDATE = uPDATEDATE;
    }

    public String getUSERSN() {
        return uSERSN;
    }

    public void setUSERSN(String uSERSN) {
        this.uSERSN = uSERSN;
    }

    public String getOWNERNAME() {
        return oWNERNAME;
    }

    public void setOWNERNAME(String oWNERNAME) {
        this.oWNERNAME = oWNERNAME;
    }

    public String getUSERSEXID() {
        return uSERSEXID;
    }

    public void setUSERSEXID(String uSERSEXID) {
        this.uSERSEXID = uSERSEXID;
    }

}