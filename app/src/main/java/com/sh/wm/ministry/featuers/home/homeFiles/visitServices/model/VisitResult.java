package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;
//store_visit_result

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "visit_result_table")
public class VisitResult {
    @PrimaryKey
    @NonNull
    @SerializedName("VISIT_ID")
    @Expose
    private String  visitId;

    @SerializedName("INSPECT_CONSTRUCT_ID")
    @Expose
    private String  constructId;

    @SerializedName("INSPECT_RESULTS_ACTION_ID")
    @Expose
    private String  inspectResultsActionId;

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

    @SerializedName("INSPECT_RESULTS_MACHINE_NAME")
    @Expose
    private String  inspectMachineName;


    @SerializedName("INSERTUSERID")
    @Expose
    private String  insertUserId;

    public VisitResult(@NonNull String visitId, String constructId, String inspectResultsActionId, String inspectResultsRecomId, String inspectResultsPlacementId, String comActionDate, String resultsActionReon, String inspectMachineName, String insertUserId) {
        this.visitId = visitId;
        this.constructId = constructId;
        this.inspectResultsActionId = inspectResultsActionId;
        this.inspectResultsRecomId = inspectResultsRecomId;
        this.inspectResultsPlacementId = inspectResultsPlacementId;
        this.comActionDate = comActionDate;
        ResultsActionReon = resultsActionReon;
        this.inspectMachineName = inspectMachineName;
        this.insertUserId = insertUserId;
    }//con
@Ignore
    public VisitResult(@NonNull String visitId) {
        this.visitId = visitId;
    }

    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    public String getInspectResultsActionId() {
        return inspectResultsActionId;
    }

    public void setInspectResultsActionId(String inspectResultsActionId) {
        this.inspectResultsActionId = inspectResultsActionId;
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

    public String getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
    }
}
