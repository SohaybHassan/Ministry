
package com.sh.wm.ministry.featuers.userfile.practicalstatus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PracticalStatusModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_work_status")
    @Expose
    private List<UserWorkStatus> userWorkStatus = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<UserWorkStatus> getUserWorkStatus() {
        return userWorkStatus;
    }

    public void setUserWorkStatus(List<UserWorkStatus> userWorkStatus) {
        this.userWorkStatus = userWorkStatus;
    }

}
