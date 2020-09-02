package com.sh.wm.ministry.featuers.userfile.userFiles.languages.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sh.wm.ministry.featuers.home.homeFiles.visitServices.model.Question_Answer;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class LanguagesTypeConverter {
    @TypeConverter
    public Object fromJson(String jsonString) {
        Type type = new TypeToken<Object>() {
        }.getType();
        return new Gson().fromJson(jsonString, type);
    }

    @TypeConverter
    public String toJson(Object object) {
        Type type = new TypeToken<Object>() {
        }.getType();
        return new Gson().toJson(object, type);
    }
    //for the question_answer at visitServices "AnswersDoa_Impl.java"
    @TypeConverter
    public static ArrayList<Question_Answer> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Question_Answer>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String fromArrayList(ArrayList<Question_Answer> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
