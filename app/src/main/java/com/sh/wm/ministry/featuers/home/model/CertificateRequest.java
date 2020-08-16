package com.sh.wm.ministry.featuers.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CertificateRequest {

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

    public CertificateRequest withMessageText(String messageText) {
        this.messageText = messageText;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CertificateRequest withStatus(String status) {
        this.status = status;
        return this;
    }

}