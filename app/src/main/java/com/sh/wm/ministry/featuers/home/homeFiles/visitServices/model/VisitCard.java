package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;

public class VisitCard {
    private String visitId ;
    private String companyName;
    private String area;
    private String startDate;
    private  int status =0 ;


    public VisitCard(String visitId, String companyName, String area, String startDate, int status) {
        this.visitId = visitId;
        this.companyName = companyName;
        this.area = area;
        this.startDate = startDate;
        this.status = status;
    }


    public VisitCard() {
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
}//end class
