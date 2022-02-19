package com.example.todoapp.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.todoapp.*

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val userInformation = AssetManager()
    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext

    fun getUserInformation(): UserDetails = userInformation.getTodoData(context).data.user_details

    fun getSurveyHistory(): List<HistorySurveyDiagnosis> {

        lateinit var surveyDiagnosis: Diagnosis

        val diagnoseses: List<Diagnosis> = userInformation.getTodoData(context).data.diagnoses

        for (diagnosis in diagnoseses ){
             surveyDiagnosis = diagnosis
        }

        Log.d("surveyHistory","surveyDiagnosis: $surveyDiagnosis")

        return surveyDiagnosis.history_survey_diagnoses
    }

    fun getCurrentDiagnosis():List<CurrentDiagnosis>{
        lateinit var currentDiagnosis: Diagnosis

        val diagnoseses: List<Diagnosis> = userInformation.getTodoData(context).data.diagnoses

        for (diagnosis in diagnoseses ){
            currentDiagnosis = diagnosis
        }

        return currentDiagnosis.current_diagnoses
    }

}