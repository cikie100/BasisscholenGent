package com.example.basisscholengent.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.basisscholengent.databinding.FragmentScholenDetailBinding
import com.example.basisscholengent.repos.RepositoryUtils
import com.example.basisscholengent.viewmodels.SchoolDetailViewModel
import com.example.basisscholengent.viewmodels.SchoolDetailViewModelFactory

class SchoolDetailFragment : Fragment() {
    private val arguments: SchoolDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentScholenDetailBinding.inflate(inflater,container,false)

        //factory geef je een repository en die geeft een ViewModelProvider.Factory terug
        val factory = SchoolDetailViewModelFactory(RepositoryUtils.createScholenRepository((requireContext())))

       // val viewModel = ViewModelProvider(this,factory).get(SchoolDetailViewModel::class.java)
        val viewModel = ViewModelProvider(this,factory).get(SchoolDetailViewModel::class.java)

        //object doorgeven aan viewmodel
        //viewModel.updateSchool(arguments.school)
        viewModel.updateSchool(arguments.schoolId)

        //observeren zodat de wijzigingen ook aan ui worden door gegeven
        viewModel.school.observe(viewLifecycleOwner, {
            binding.school = it
        })


        return  binding.root
    }
}