package com.sh.wm.ministry.featuers.userfile.languages.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

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
}
