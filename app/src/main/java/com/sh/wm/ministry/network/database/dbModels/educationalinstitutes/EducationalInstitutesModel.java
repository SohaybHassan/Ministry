
package com.sh.wm.ministry.network.database.dbModels.educationalinstitutes;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EducationalInstitutesModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("educational_institutes")
    @Expose
    private List<EducationalInstitute> educationalInstitutes = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<EducationalInstitute> getEducationalInstitutes() {
        return educationalInstitutes;
    }

    public void setEducationalInstitutes(List<EducationalInstitute> educationalInstitutes) {
        this.educationalInstitutes = educationalInstitutes;
    }

}
