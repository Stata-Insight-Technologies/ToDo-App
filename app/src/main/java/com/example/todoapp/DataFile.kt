package com.example.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*

data class TodoModel(
    val image:Int
    ,val name:String
    ,val date: Date)

@RequiresApi(Build.VERSION_CODES.N)
val currentDate: Date = android.icu.util.Calendar.getInstance().time

val surveyHistory = listOf(TodoModel(
    R.drawable.ic_frame_temp,"Body Temperature", currentDate),
    TodoModel(
        R.drawable.ic_frame_blood,"Blood Pressure", currentDate),
    TodoModel(
    R.drawable.ic_frame_conical,"Laboratory tests", currentDate),
    TodoModel(
        R.drawable.ic_frame_temp,"Body Temperature", currentDate),
    TodoModel(
        R.drawable.ic_frame_blood,"Blood Pressure", currentDate),
    TodoModel(
        R.drawable.ic_frame_conical,"Laboratory tests", currentDate),
    TodoModel(
        R.drawable.ic_frame_temp,"Body Temperature", currentDate),
    TodoModel(
        R.drawable.ic_frame_blood,"Blood Pressure", currentDate),
    TodoModel(
        R.drawable.ic_frame_conical,"Laboratory tests", currentDate),

    TodoModel(
        R.drawable.ic_frame_temp,"Body Temperature", currentDate),
    TodoModel(
        R.drawable.ic_frame_blood,"Blood Pressure", currentDate),
    TodoModel(
        R.drawable.ic_frame_conical,"Laboratory tests", currentDate),

    TodoModel(
        R.drawable.ic_frame_temp,"Body Temperature", currentDate),
    TodoModel(
        R.drawable.ic_frame_blood,"Blood Pressure", currentDate),
    TodoModel(
        R.drawable.ic_frame_conical,"Laboratory tests", currentDate),

    TodoModel(
        R.drawable.ic_frame_temp,"Body Temperature", currentDate),
    TodoModel(
        R.drawable.ic_frame_blood,"Blood Pressure", currentDate),
    TodoModel(
        R.drawable.ic_frame_conical,"Laboratory tests", currentDate),
)

val currentDiagnosis = listOf(TodoModel(
    R.drawable.ic_frame_lungs,"Septic Embolization", currentDate))
//date converter
fun getFormattedDate(lastUpdated: Date?): String {
//        var time = "Last Updated: "
    var time = lastUpdated?.let {
        val sdf = SimpleDateFormat("HH:mm d MMM, yyyy", Locale.getDefault())
        sdf.format(lastUpdated)
    } ?: "Not Found"
    return time
}