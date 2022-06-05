package com.example.hadeyesedictionary.Helper

import android.content.Context
import android.util.Log
import com.example.hadeyesedictionary.R
import org.json.JSONArray
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*


class GameHelper(var  context: Context) {
     var words = ArrayList<String>()
    var random= Random()
    val checking = arrayOf(
      "Kina","Mine"
    )

    @Throws(IOException::class)
    private fun readJSONDataFromFile(): String? {
        var inputStream: InputStream? = null
        val builder = java.lang.StringBuilder()
        try {
            var jsonString: String? = null
            inputStream = context.resources.openRawResource(R.raw.translation)
            val bufferedReader = BufferedReader(
                InputStreamReader(inputStream, "UTF-8")
            )
            while (bufferedReader.readLine().also { jsonString = it } != null) {
                builder.append(jsonString)
            }
        } finally {
            inputStream?.close()
        }
        return String(builder)
    }
     fun addItemsFromJSON() {
        try {
            val jsonDataString = readJSONDataFromFile()
            val jsonArray = JSONArray(jsonDataString)
            for (i in 0 until jsonArray.length()) {
                val itemObj = jsonArray.getJSONObject(i)
                val Haddiyisaa = itemObj.getString("Haddiyisaa")
                words.add(Haddiyisaa)
            }
        } catch (e: JSONException) {
            Log.d("TAG", "addItemsFromJSON: ", e)
        } catch (e: IOException) {
            Log.d("TAG", "addItemsFromJSON: ", e)
        }
    }

    // random letters from one of the array lists
    fun randomWord(): String? {
        return checking[random.nextInt(checking.count())]
    }
    // shuffle the correct answer from the array words
    fun correctAnswer(word:String):String{
        if (word != null && "" != word) {
            val a = word.toCharArray()
            for (i in a.indices) {
                val j: Int = random.nextInt(a.size)
                val tmp = a[i]
                a[i] = a[j]
                a[j] = tmp
            }
            return String(a)
        }
        return word
    }
}