package com.sh.wm.ministry.featuers.userfile.dependents.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserWorkerInsertModel {

    @SerializedName("message_text")
    @Expose
    private String messageText;
    @SerializedName("status")
    @Expose
    private String status;

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}