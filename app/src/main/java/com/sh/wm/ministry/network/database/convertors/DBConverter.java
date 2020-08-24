package com.sh.wm.ministry.network.database.convertors;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class DBConverter {
    @androidx.room.TypeConverter
    public Object fromJson(String jsonString) {
        Type type = new TypeToken<Object>() {
        }.getType();
        return new Gson().fromJson(jsonString, type);
    }

    @androidx.room.TypeConverter
    public String toJson(Object object) {
        Type type = new TypeToken<Object>() {
        }.getType();
        return new Gson().toJson(object, type);
    }
}
