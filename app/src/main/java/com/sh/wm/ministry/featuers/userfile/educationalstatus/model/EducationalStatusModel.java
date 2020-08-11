
package com.sh.wm.ministry.featuers.userfile.educationalstatus.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EducationalStatusModel {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("user_educational_status")
    @Expose
    private List<UserEducationalStatus> userEducationalStatus = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<UserEducationalStatus> getUserEducationalStatus() {
        return userEducationalStatus;
    }

    public void setUserEducationalStatus(List<UserEducationalStatus> userEducationalStatus) {
        this.userEducationalStatus = userEducationalStatus;
    }

}
