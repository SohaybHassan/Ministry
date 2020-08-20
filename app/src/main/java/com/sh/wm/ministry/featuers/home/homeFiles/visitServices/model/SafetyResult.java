package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;
//get_safty_result api
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SafetyResult {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("ACTION_TAKEN")
    @Expose
    private Object aCTIONTAKEN;
    @SerializedName("RECOMMENDED_ACTION")
    @Expose
    private Object rECOMMENDEDACTION;
    @SerializedName("ADVISED_ACTION")
    @Expose
    private Object aDVISEDACTION;
    @SerializedName("construction_name")
    @Expose
    private String constructionName;
    @SerializedName("contruct_num")
    @Expose
    private String contructNum;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getACTIONTAKEN() {
        return aCTIONTAKEN;
    }

    public void setACTIONTAKEN(Object aCTIONTAKEN) {
        this.aCTIONTAKEN = aCTIONTAKEN;
    }

    public Object getRECOMMENDEDACTION() {
        return rECOMMENDEDACTION;
    }

    public void setRECOMMENDEDACTION(Object rECOMMENDEDACTION) {
        this.rECOMMENDEDACTION = rECOMMENDEDACTION;
    }

    public Object getADVISEDACTION() {
        return aDVISEDACTION;
    }

    public void setADVISEDACTION(Object aDVISEDACTION) {
        this.aDVISEDACTION = aDVISEDACTION;
    }

    public String getConstructionName() {
        return constructionName;
    }

    public void setConstructionName(String constructionName) {
        this.constructionName = constructionName;
    }

    public String getContructNum() {
        return contructNum;
    }

    public void setContructNum(String contructNum) {
        this.contructNum = contructNum;
    }

}