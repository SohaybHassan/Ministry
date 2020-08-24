
package com.sh.wm.ministry.network.database.dbModels.eduprograms;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EduProgramsModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("edu_programs")
    @Expose
    private List<EduProgram> eduPrograms = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<EduProgram> getEduPrograms() {
        return eduPrograms;
    }

    public void setEduPrograms(List<EduProgram> eduPrograms) {
        this.eduPrograms = eduPrograms;
    }

}
