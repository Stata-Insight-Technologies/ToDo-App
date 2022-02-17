package com.example.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.todoapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSurveyHistory.adapter = SurveyHistoryAdapter(requireContext(), surveyHistory)

        binding.rvCurrentDiagnosis.adapter = CurrentDiagnosisAdapter(requireContext(), currentDiagnosis)

        binding.delete.setOnClickListener {
            findNavController().navigate(R.id.to_deleteFragment)
        }

        binding.backArrow.setOnClickListener {
            Toast.makeText(requireContext(),"Back to HomeScreen", Toast.LENGTH_SHORT).show()
        }

        binding.edit.setOnClickListener {
            Toast.makeText(requireContext(),"To edit the Todos", Toast.LENGTH_SHORT).show()
        }

        binding.fab.setOnClickListener {
            Toast.makeText(requireContext(),"Create a new Todo", Toast.LENGTH_SHORT).show()
        }

    }

}