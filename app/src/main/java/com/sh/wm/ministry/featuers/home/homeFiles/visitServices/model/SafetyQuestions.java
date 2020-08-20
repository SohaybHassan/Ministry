package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;
//{{url}}/get_safty_questions_by_subjectid?SUBJECT_LAW_ID=1 api
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SafetyQuestions {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("safty_questions")
    @Expose
    private List<SaftyQuestion> saftyQuestions = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SaftyQuestion> getSaftyQuestions() {
        return saftyQuestions;
    }

    public void setSaftyQuestions(List<SaftyQuestion> saftyQuestions) {
        this.saftyQuestions = saftyQuestions;
    }

}
