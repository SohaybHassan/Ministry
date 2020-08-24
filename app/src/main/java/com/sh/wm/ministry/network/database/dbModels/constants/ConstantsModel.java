
package com.sh.wm.ministry.network.database.dbModels.constants;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConstantsModel {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("constants")
    @Expose
    private List<Constants> constants = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Constants> getConstants() {
        return constants;
    }

    public void setConstants(List<Constants> constants) {
        this.constants = constants;
    }

}
