package com.example.todoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class SurveyHistoryAdapter(private val context: Context, private val surveyHistory: List<HistorySurveyDiagnosis>)
    : RecyclerView.Adapter<SurveyHistoryAdapter.SurveyHistoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurveyHistoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.content_display,parent,false)
        return SurveyHistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SurveyHistoryViewHolder, position: Int) {
        holder.image.setImageResource(R.drawable.ic_frame_lungs)
        holder.name.text = surveyHistory[position].diagnosis_name
        holder.date.text = surveyHistory[position].date
    }

    override fun getItemCount(): Int {
        return surveyHistory.size
    }

    inner class SurveyHistoryViewHolder(private val itemView:View):RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.display_image)
        val name: TextView = itemView.findViewById(R.id.name)
        val date: TextView = itemView.findViewById(R.id.date)
    }

}