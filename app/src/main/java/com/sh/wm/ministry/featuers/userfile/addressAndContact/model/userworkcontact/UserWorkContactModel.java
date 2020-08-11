package com.sh.wm.ministry.featuers.userfile.addressAndContact.model.userworkcontact;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserWorkContactModel {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("user_work_contact")
    @Expose
    private UserWorkContact userWorkContact;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserWorkContact getUserWorkContact() {
        return userWorkContact;
    }

    public void setUserWorkContact(UserWorkContact userWorkContact) {
        this.userWorkContact = userWorkContact;
    }

}