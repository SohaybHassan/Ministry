package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.http.Field;

@Entity(tableName = "recommendations_table")
public class Recommendations {
    @PrimaryKey
    @NonNull
    @SerializedName("VISIT_ID")
    @Expose
    private String  visitId;
    @SerializedName("CONSTRUCT_ID")
    @Expose
     String constructId;
    @SerializedName("COM_INSPECT_RECOMM_ID")
    @Expose
   private String recommId;
    @SerializedName ("COM_INSPECT_RECOMM_ADOPTED_ID")
    @Expose
   private String adoptedRecomId;
    @SerializedName ("INSPECT_RESULTS_RECOM_ID")
    @Expose
   private String inspectResultRecommId;
    @SerializedName("COM_INSPECT_RECOMM_ACTIONS_ID")
    @Expose
    private String recommActionId;
    @SerializedName("COM_INSPECTN_MACHINE_NAME")
    @Expose
   private String machineName;
    @SerializedName("COM_INSPECTN_ACTION_DATE")
    @Expose
    private String actionDate ;
    @SerializedName ("INSERTUSERID")
    @Expose
    private String insertUserId;

    public Recommendations(@NonNull String visitId, String constructId, String recommId, String adoptedRecomId, String inspectResultRecommId, String recommActionId, String machineName, String actionDate, String insertUserId) {
        this.visitId = visitId;
        this.constructId = constructId;
        this.recommId = recommId;
        this.adoptedRecomId = adoptedRecomId;
        this.inspectResultRecommId = inspectResultRecommId;
        this.recommActionId = recommActionId;
        this.machineName = machineName;
        this.actionDate = actionDate;
        this.insertUserId = insertUserId;
    }

    @Ignore
    public Recommendations(@NonNull String visitId) {
        this.visitId = visitId;
    }

    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    public String getRecommId() {
        return recommId;
    }

    public void setRecommId(String recommId) {
        this.recommId = recommId;
    }

    public String getAdoptedRecomId() {
        return adoptedRecomId;
    }

    public void setAdoptedRecomId(String adoptedRecomId) {
        this.adoptedRecomId = adoptedRecomId;
    }

    public String getInspectResultRecommId() {
        return inspectResultRecommId;
    }

    public void setInspectResultRecommId(String inspectResultRecommId) {
        this.inspectResultRecommId = inspectResultRecommId;
    }

    public String getRecommActionId() {
        return recommActionId;
    }

    public void setRecommActionId(String recommActionId) {
        this.recommActionId = recommActionId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getActionDate() {
        return actionDate;
    }

    public void setActionDate(String actionDate) {
        this.actionDate = actionDate;
    }

    public String getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
    }
    @NonNull
    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(@NonNull String visitId) {
        this.visitId = visitId;
    }

}
