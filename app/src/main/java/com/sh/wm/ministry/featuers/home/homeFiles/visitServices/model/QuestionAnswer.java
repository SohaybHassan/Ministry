package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


@Entity(tableName = "answers_table")
public class QuestionAnswer {

    @PrimaryKey
    @NonNull
    @SerializedName("INSPECTION_VISIT_ID")
    @Expose
   private String inspectionVisitId;
    @SerializedName("CONSTRUCT_ID")
    @Expose
    private String constructId;
    @SerializedName("ANSWERS")
    @Expose
    private ArrayList<Answer> answers;
    @SerializedName("INSERT_USERID")
    @Expose
    private String insertUserId;

    public QuestionAnswer(@NonNull String inspectionVisitId, String constructId, ArrayList<Answer> answers, String insertUserId) {
        this.inspectionVisitId = inspectionVisitId;
        this.constructId = constructId;
        this.answers = answers;
        this.insertUserId = insertUserId;
    }

    @Ignore
    public QuestionAnswer(@NonNull String inspectionVisitId) {
        this.inspectionVisitId = inspectionVisitId;
    }

    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public String getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
    }
}
