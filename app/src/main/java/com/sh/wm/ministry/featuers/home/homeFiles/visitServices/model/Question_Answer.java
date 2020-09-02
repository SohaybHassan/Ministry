package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question_Answer {
    @SerializedName("question_id")
    @Expose
    private String questionId;
    @SerializedName("answer")
    @Expose
    private String answer;

    public Question_Answer(String questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
