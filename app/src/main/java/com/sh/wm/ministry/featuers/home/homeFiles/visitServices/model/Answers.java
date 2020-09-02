package com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


@Entity(tableName = "answers_table")
public class Answers {

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
    private ArrayList<Question_Answer> questionAnswers;
    @SerializedName("INSERT_USERID")
    @Expose
    private String insertUserId;

    public Answers(@NonNull String inspectionVisitId, String constructId, ArrayList<Question_Answer> questionAnswers, String insertUserId) {
        this.inspectionVisitId = inspectionVisitId;
        this.constructId = constructId;
        this.questionAnswers = questionAnswers;
        this.insertUserId = insertUserId;
    }

    @Ignore
    public Answers(@NonNull String inspectionVisitId) {
        this.inspectionVisitId = inspectionVisitId;
    }

    public String getConstructId() {
        return constructId;
    }

    public void setConstructId(String constructId) {
        this.constructId = constructId;
    }

    public ArrayList<Question_Answer> getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(ArrayList<Question_Answer> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    public String getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
    }

    @NonNull
    public String getInspectionVisitId() {
        return inspectionVisitId;
    }

    public void setInspectionVisitId(@NonNull String inspectionVisitId) {
        this.inspectionVisitId = inspectionVisitId;
    }
}
