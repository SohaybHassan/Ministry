
package com.sh.wm.ministry.featuers.userfile.majorservices.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfoModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_work_info")
    @Expose
    private UserWorkInfo userWorkInfo;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserWorkInfo getUserWorkInfo() {
        return userWorkInfo;
    }

    public void setUserWorkInfo(UserWorkInfo userWorkInfo) {
        this.userWorkInfo = userWorkInfo;
    }

}
