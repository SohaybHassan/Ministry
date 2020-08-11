
package com.sh.wm.ministry.featuers.userfile.trainingskills.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrainingSkillsModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("user_work_status")
    @Expose
    private List<TrainingSkills> trainingSkillsWorkStatuses = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<TrainingSkills> getTrainingSkillsWorkStatuses() {
        return trainingSkillsWorkStatuses;
    }

    public void setTrainingSkillsWorkStatuses(List<TrainingSkills> trainingSkillsWorkStatuses) {
        this.trainingSkillsWorkStatuses = trainingSkillsWorkStatuses;
    }

}
