
package com.sh.wm.ministry.featuers.userfile.userFiles.career.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserCareerModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_career")
    @Expose
    private List<UserCareer> userCareer = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<UserCareer> getUserCareer() {
        return userCareer;
    }

    public void setUserCareer(List<UserCareer> userCareer) {
        this.userCareer = userCareer;
    }

}
