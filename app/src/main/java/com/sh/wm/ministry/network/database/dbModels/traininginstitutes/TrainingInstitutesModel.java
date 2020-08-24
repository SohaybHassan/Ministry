
package com.sh.wm.ministry.network.database.dbModels.traininginstitutes;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrainingInstitutesModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("training_institutes")
    @Expose
    private List<TrainingInstitute> trainingInstitutes = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<TrainingInstitute> getTrainingInstitutes() {
        return trainingInstitutes;
    }

    public void setTrainingInstitutes(List<TrainingInstitute> trainingInstitutes) {
        this.trainingInstitutes = trainingInstitutes;
    }

}
