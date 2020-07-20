package com.sh.wm.ministry.featuers.home.homeFiles.alarmForm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PalLaw {

@SerializedName("status")
@Expose
private int status;
@SerializedName("pal_law_desc")
@Expose
private String palLawDesc;

public int getStatus() {
return status;
}

public void setStatus(int status) {
this.status = status;
}

public String getPalLawDesc() {
return palLawDesc;
}

public void setPalLawDesc(String palLawDesc) {
this.palLawDesc = palLawDesc;
}

}