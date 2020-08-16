package com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConstructByName {

@SerializedName("status")
@Expose
private int status;
@SerializedName("constructs")
@Expose
private List<Construct> constructs = null;

public int getStatus() {
return status;
}

public void setStatus(int status) {
this.status = status;
}

public List<Construct> getConstructs() {
return constructs;
}

public void setConstructs(List<Construct> constructs) {
this.constructs = constructs;
}

}