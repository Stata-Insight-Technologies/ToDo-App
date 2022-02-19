package com.example.todoapp

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class AssetManager {

    fun getTodoData(context: Context): DataModel {

       lateinit var jsonString: String

        try {
            jsonString = context.assets.open("data.json")
                .bufferedReader().use {
                    it.readText()
                }

            Log.d("TAG", "getUserDetail: $jsonString")


        }catch (e: IOException) {
            e.stackTrace
        }
        val dataModel = object : TypeToken<DataModel>(){}.type
        val todoData: DataModel = Gson().fromJson(jsonString,dataModel)

        Log.d("todoData", "TodoData: $todoData")

        //getting userDetails
        val userDetails: List<Diagnosis> = todoData.data.diagnoses
        Log.d("userDetail", "Username: ${userDetails}")

        return todoData
    }
}