
package com.sh.wm.ministry.featuers.userfile.userFiles.languages.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserLanguagesModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_language")
    @Expose
    private List<UserLanguage> userLanguage = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<UserLanguage> getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(List<UserLanguage> userLanguage) {
        this.userLanguage = userLanguage;
    }

}
