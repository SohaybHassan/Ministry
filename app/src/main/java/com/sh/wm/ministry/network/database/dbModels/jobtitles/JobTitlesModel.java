
package com.sh.wm.ministry.network.database.dbModels.jobtitles;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobTitlesModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("job_titles")
    @Expose
    private List<JobTitle> jobTitles = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<JobTitle> getJobTitles() {
        return jobTitles;
    }

    public void setJobTitles(List<JobTitle> jobTitles) {
        this.jobTitles = jobTitles;
    }

}
