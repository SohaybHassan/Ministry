
package com.sh.wm.ministry.featuers.userfile.userFiles.health.model.health;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserHealthStatusModel {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("user_health_status")
    @Expose
    private List<UserHealthStatus> userHealthStatus = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<UserHealthStatus> getUserHealthStatus() {
        return userHealthStatus;
    }

    public void setUserHealthStatus(List<UserHealthStatus> userHealthStatus) {
        this.userHealthStatus = userHealthStatus;
    }

}
