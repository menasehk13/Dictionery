package com.example.hadeyesedictionary.Helper

import android.content.Context
import com.example.hadeyesedictionary.Model.HomeData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class SharedLoad(var context: Context) {
    var sharedpref = context.getSharedPreferences("prefVal",Context.MODE_PRIVATE)
    val gson = Gson()

    fun loadData(): ArrayList<HomeData>? {
        var favoriteList = ArrayList<HomeData>()
        val json = sharedpref.getString("favorite", null)
        val type: Type = object : TypeToken<ArrayList<HomeData?>?>() {}.type
        if (favoriteList!=null){
            favoriteList = gson.fromJson(json,type)
            return favoriteList
        }
        return null
    }
}