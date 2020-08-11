
package com.sh.wm.ministry.featuers.userfile.languages.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllLanguagesModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("languages")
    @Expose
    private List<Language> languages = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

}
