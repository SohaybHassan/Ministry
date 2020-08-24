
package com.sh.wm.ministry.network.database.dbModels.jobs;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobsModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("jobs")
    @Expose
    private List<Job> jobs = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

}
