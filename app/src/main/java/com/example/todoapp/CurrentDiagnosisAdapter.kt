package com.example.todoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CurrentDiagnosisAdapter(val context: Context, val currentDiagnosis: List<TodoModel>)
    : RecyclerView.Adapter<CurrentDiagnosisAdapter.CurrentDiagnosisViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentDiagnosisViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.content_display,parent,false)
        return CurrentDiagnosisViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CurrentDiagnosisViewHolder, position: Int) {
        holder.image.setImageResource(currentDiagnosis[position].image)
        holder.name.text= currentDiagnosis[position].name
        holder.date.text = getFormattedDate(currentDiagnosis[position].date)
    }

    override fun getItemCount(): Int {
        return currentDiagnosis.size
    }

    inner class CurrentDiagnosisViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val image: ImageView = itemView.findViewById(R.id.display_image)
        val name: TextView = itemView.findViewById(R.id.name)
        val date: TextView = itemView.findViewById(R.id.date)
    }
}