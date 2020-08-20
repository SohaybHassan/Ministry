package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;

//{{url}}/store_questions_answer
//{{url}}/store_inspection_revisit_results
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreAnswer {

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