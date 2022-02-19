package com.example.todoapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.todoapp.databinding.FragmentHomeBinding
import com.example.todoapp.viewModel.TodoViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

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
            binding = FragmentHomeBinding.inflate(inflater,container,false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            //Display user profile
            showUserProfile()

            //Manages the current diagnosis and history of Survey RecyclerView
            homeRecyclerManager()


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

        private fun showUserProfile(){

            binding.profileName.text = viewModel.getUserInformation().name
            binding.profileEmail.text = viewModel.getUserInformation().email
            binding.profilePicture.load(viewModel.getUserInformation().avatar_url){
                placeholder(R.drawable.ic_baseline_person_24)

                error(R.drawable.ic_baseline_person_24)
            }
            binding.age1.text = viewModel.getUserInformation().age
            binding.age2.text = viewModel.getUserInformation().age
            binding.age3.text = viewModel.getUserInformation().age
    }

    private fun homeRecyclerManager(){
        binding.rvSurveyHistory.adapter = SurveyHistoryAdapter(requireContext(), viewModel.getSurveyHistory())

        binding.rvCurrentDiagnosis.adapter = CurrentDiagnosisAdapter(requireContext(), viewModel.getCurrentDiagnosis())
    }

}