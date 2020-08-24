
package com.sh.wm.ministry.network.database.dbModels.regions;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionsModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("regions")
    @Expose
    private List<Region> regions = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

}
