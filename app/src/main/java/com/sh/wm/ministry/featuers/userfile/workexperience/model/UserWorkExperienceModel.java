
package com.sh.wm.ministry.featuers.userfile.workexperience.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserWorkExperienceModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_work_experience")
    @Expose
    private List<UserWorkExperience> userWorkExperience = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<UserWorkExperience> getUserWorkExperience() {
        return userWorkExperience;
    }

    public void setUserWorkExperience(List<UserWorkExperience> userWorkExperience) {
        this.userWorkExperience = userWorkExperience;
    }

}
