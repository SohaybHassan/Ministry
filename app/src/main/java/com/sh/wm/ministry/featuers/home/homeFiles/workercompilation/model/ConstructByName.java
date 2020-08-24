package com.sh.wm.ministry.featuers.home.homeFiles.workercompilation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ConstructByName {

@SerializedName("status")
@Expose
private int status;
@SerializedName("constructs")
@Expose
private ArrayList<Construct> constructs = null;

public int getStatus() {
return status;
}

public void setStatus(int status) {
this.status = status;
}

public ArrayList<Construct> getConstructs() {
return constructs;
}

public void setConstructs(ArrayList<Construct> constructs) {
this.constructs = constructs;
}

}