package com.sh.wm.ministry.featuers.home.homeFiles.QayedArchive.model;

public class ArchiveCard {
    private String qayedDate;
    private String workStatusDesc;
    private String workStatusDescDesc;
    private String status;

    public ArchiveCard() {
    }
    public ArchiveCard(String qayedDate, String workStatusDesc, String workStatusDescDesc, String status) {
        this.qayedDate = qayedDate;
        this.workStatusDesc = workStatusDesc;
        this.workStatusDescDesc = workStatusDescDesc;
        this.status = status;
    }

    public String getQayedDate() {
        return qayedDate;
    }

    public void setQayedDate(String qayedDate) {
        this.qayedDate = qayedDate;
    }

    public String getWorkStatusDesc() {
        return workStatusDesc;
    }

    public void setWorkStatusDesc(String workStatusDesc) {
        this.workStatusDesc = workStatusDesc;
    }

    public String getWorkStatusDescDesc() {
        return workStatusDescDesc;
    }

    public void setWorkStatusDescDesc(String workStatusDescDesc) {
        this.workStatusDescDesc = workStatusDescDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}//end card
