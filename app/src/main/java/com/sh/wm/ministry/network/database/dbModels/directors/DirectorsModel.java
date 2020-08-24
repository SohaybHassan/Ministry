
package com.sh.wm.ministry.network.database.dbModels.directors;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DirectorsModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("directors")
    @Expose
    private List<Director> directors = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

}
