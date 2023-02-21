package com.staygrateful.mbkmsample.room.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConverter<T> {
    @TypeConverter
    fun fromList(models: ArrayList<T>?): String? {
        if (models == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<ArrayList<T>?>() {}.type
        return gson.toJson(models, type)
    }

    @TypeConverter
    fun toList(values: String?): ArrayList<T> {
        if (values == null) {
            return ArrayList()
        }
        val gson = Gson()
        val type = object : TypeToken<ArrayList<T>?>() {}.type
        return gson.fromJson(values, type)
    }
}