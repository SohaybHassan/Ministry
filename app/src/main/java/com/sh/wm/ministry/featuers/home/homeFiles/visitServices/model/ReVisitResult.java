package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "re_visit_table")
public class ReVisitResult {

    @SerializedName("CONSTRUCT_ID")
    @Expose
    private String  constructId;

    @SerializedName("VIOLATIONS_REMOVAL")
    @Expose
    private String  violationRemoval;

    @SerializedName("INSPECT_RESULTS_RECOM_ID")
    @Expose
    private String  inspectResultsRecomId;

    @SerializedName("INSPECT_RESULTS_PLACEMENT_ID")
    @Expose
    private String  inspectResultsPlacementId;

    @SerializedName("INSPECT_RESULTS_ACTIN_DATE")
    @Expose
    private String  comActionDate;

    @SerializedName("INSPECT_RESULTS_ACTION_REON")
    @Expose
    private String  ResultsActionReon;

    @SerializedName("COM_INSPECTN_MACHINE_NAME")
    @Expose
    private String  inspectMachineName;

    @PrimaryKey
    @NonNull
    @SerializedName("VISIT_ID")
    @Expose
    private String  visitId;

   public  ReVisitResult(){

     }
    @Ignore
    public ReVisitResult(String constructId, String violationRemoval, String inspectResultsRecomId, String inspectResultsPlacementId, String comActionDate, String resultsActionReon, String inspectMachineName, @NonNull String visitId) {
        this.constructId = constructId;
        this.violationRemoval = violationRemoval;
        this.inspectResultsRecomId = inspectResultsRecomId;
        this.inspectResultsPlacementId = inspectResultsPlacementId;
        this.comActionDate = comActionDate;
        ResultsActionReon = resultsActionReon;
        this.inspectMachineName = inspectMachineName;
        this.visitId = visitId;
    }

    @Ignore
    public ReVisitResult(@NonNull String visitId) {
        this.visitId = visitId;
    }

    @NonNull
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(@NonNull String visitId) {
        this.visitId = visitId;
    }

    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    public String getViolationRemoval() {
        return violationRemoval;
    }

    public void setViolationRemoval(String violationRemoval) {
        this.violationRemoval = violationRemoval;
    }

    public String getInspectResultsRecomId() {
        return inspectResultsRecomId;
    }

    public void setInspectResultsRecomId(String inspectResultsRecomId) {
        this.inspectResultsRecomId = inspectResultsRecomId;
    }

    public String getInspectResultsPlacementId() {
        return inspectResultsPlacementId;
    }

    public void setInspectResultsPlacementId(String inspectResultsPlacementId) {
        this.inspectResultsPlacementId = inspectResultsPlacementId;
    }

    public String getComActionDate() {
        return comActionDate;
    }

    public void setComActionDate(String comActionDate) {
        this.comActionDate = comActionDate;
    }

    public String getResultsActionReon() {
        return ResultsActionReon;
    }

    public void setResultsActionReon(String resultsActionReon) {
        ResultsActionReon = resultsActionReon;
    }

    public String getInspectMachineName() {
        return inspectMachineName;
    }

    public void setInspectMachineName(String inspectMachineName) {
        this.inspectMachineName = inspectMachineName;
    }
}
