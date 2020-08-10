
package com.sh.wm.ministry.featuers.home.homeFiles.inspection.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InspectionVisit {

    @SerializedName("status")
    @Expose
    private long status;
    @SerializedName("COUNT_ROW")
    @Expose
    private String cOUNTROW;
    @SerializedName("inspection_visit")
    @Expose
    private List<InspectionVisit_> inspectionVisit = new ArrayList<InspectionVisit_>();

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public InspectionVisit withStatus(long status) {
        this.status = status;
        return this;
    }

    public String getCOUNTROW() {
        return cOUNTROW;
    }

    public void setCOUNTROW(String cOUNTROW) {
        this.cOUNTROW = cOUNTROW;
    }

    public InspectionVisit withCOUNTROW(String cOUNTROW) {
        this.cOUNTROW = cOUNTROW;
        return this;
    }

    public List<InspectionVisit_> getInspectionVisit() {
        return inspectionVisit;
    }

    public void setInspectionVisit(List<InspectionVisit_> inspectionVisit) {
        this.inspectionVisit = inspectionVisit;
    }

    public InspectionVisit withInspectionVisit(List<InspectionVisit_> inspectionVisit) {
        this.inspectionVisit = inspectionVisit;
        return this;
    }

}
