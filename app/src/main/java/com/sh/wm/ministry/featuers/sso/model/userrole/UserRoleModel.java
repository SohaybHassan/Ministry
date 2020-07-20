
package com.sh.wm.ministry.featuers.sso.model.userrole;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRoleModel {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("auth_token")
    @Expose
    private String authToken;
    @SerializedName("user_role")
    @Expose
    private UserRole userRole;

    @SerializedName("user_work_info")
    private UserWorkInfo userWorkInfo;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserWorkInfo getUserWorkInfo() {
        return userWorkInfo;
    }

    public void setUserWorkInfo(UserWorkInfo userWorkInfo) {
        this.userWorkInfo = userWorkInfo;
    }

}
