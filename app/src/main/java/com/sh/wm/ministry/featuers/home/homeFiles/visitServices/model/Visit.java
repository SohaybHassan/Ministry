package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "visits_table")
public class Visit {
    @PrimaryKey
    @NonNull
    @SerializedName("VISIT_ID")
    @Expose
    private String visitId ;
    @SerializedName("COMPANY_NAME")
    @Expose
    private String companyName;
    @SerializedName("AREA")
    @Expose
    private String area;
    @SerializedName("START_DATE")
    @Expose
    private String startDate;
    @SerializedName("STATUS")
    @Expose
    private  int status =0 ;
    @SerializedName("INSERTED")
    @Expose
    private boolean inserted=false;



    public Visit(String visitId, String companyName, String area, String startDate, int status) {
        this.visitId = visitId;
        this.companyName = companyName;
        this.area = area;
        this.startDate = startDate;
        this.status = status;
    }

     @Ignore
    public Visit(String visitId) {
        this.visitId=visitId;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public boolean isInserted() {
        return inserted;
    }

    public void setInserted(boolean inserted) {
        this.inserted = inserted;
    }



}//end class
