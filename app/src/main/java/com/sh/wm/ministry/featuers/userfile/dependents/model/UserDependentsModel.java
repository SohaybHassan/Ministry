
package com.sh.wm.ministry.featuers.userfile.dependents.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserDependentsModel {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("user_dependents")
    @Expose
    private List<UserDependent> userDependents = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<UserDependent> getUserDependents() {
        return userDependents;
    }

    public void setUserDependents(List<UserDependent> userDependents) {
        this.userDependents = userDependents;
    }

}
