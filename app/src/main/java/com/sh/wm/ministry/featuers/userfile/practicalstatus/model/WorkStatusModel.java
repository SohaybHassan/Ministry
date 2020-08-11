
package com.sh.wm.ministry.featuers.userfile.practicalstatus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WorkStatusModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("work_status")
    @Expose
    private List<WorkStatus> workStatus = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<WorkStatus> getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(List<WorkStatus> workStatus) {
        this.workStatus = workStatus;
    }

}
