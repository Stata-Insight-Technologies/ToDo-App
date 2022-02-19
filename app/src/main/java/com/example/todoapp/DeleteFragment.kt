package com.example.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.todoapp.databinding.FragmentDeleteBinding
import com.example.todoapp.viewModel.TodoViewModel

class DeleteFragment : Fragment() {
    lateinit var binding: FragmentDeleteBinding

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(TodoViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDeleteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSurveyHistory.adapter = SurveyHistoryAdapter(requireContext(),viewModel.getSurveyHistory() )

        binding.rvCurrentDiagnosis.adapter = CurrentDiagnosisAdapter(requireContext(), viewModel.getCurrentDiagnosis())

        binding.backArrow.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.tvCancel.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.tvDelete.setOnClickListener {
            Toast.makeText(requireContext(),"Delete a select content", Toast.LENGTH_SHORT).show()
        }
    }


}