package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;
//get_inspection_visit_plan_data api
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class VisitPlanData {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("COUNT_ROW")
    @Expose
    private String cOUNTROW;
    @SerializedName("inspection_visit")
    @Expose
    private List<InspectionVisit> inspectionVisit = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCOUNTROW() {
        return cOUNTROW;
    }

    public void setCOUNTROW(String cOUNTROW) {
        this.cOUNTROW = cOUNTROW;
    }

    public List<InspectionVisit> getInspectionVisit() {
        return inspectionVisit;
    }

    public void setInspectionVisit(List<InspectionVisit> inspectionVisit) {
        this.inspectionVisit = inspectionVisit;
    }

}
