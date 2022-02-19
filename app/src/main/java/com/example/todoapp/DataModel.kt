package com.example.todoapp

data class DataModel(
    val `data`: Data,
    val success: Boolean
)

data class Data(
    val diagnoses: List<Diagnosis>,
    val user_details: UserDetails
)

data class Diagnosis(
    val current_diagnoses: List<CurrentDiagnosis>,
    val history_survey_diagnoses: List<HistorySurveyDiagnosis>
)

data class UserDetails(
    val age: String,
    val avatar_url: String,
    val email: String,
    val name: String
)

data class CurrentDiagnosis(
    val date: String,
    val diagnosis_name: String
)

data class HistorySurveyDiagnosis(
    val date: String,
    val diagnosis_name: String
)