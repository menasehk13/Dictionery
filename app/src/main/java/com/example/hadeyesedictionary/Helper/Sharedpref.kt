package com.example.hadeyesedictionary.Helper

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.hadeyesedictionary.Model.HomeData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Sharedpref(var  context: Context,var listArray:ArrayList<HomeData>) {
    var sharedpref = context.getSharedPreferences("prefVal",Context.MODE_PRIVATE)
    val gson = Gson()

    fun saveData(){
        val editor = sharedpref.edit()
        val json = gson.toJson(listArray)
        editor.putString("favorite",json)
        editor.apply()
    }
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