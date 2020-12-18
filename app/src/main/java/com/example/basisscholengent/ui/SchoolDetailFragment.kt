package com.example.basisscholengent.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.basisscholengent.SchoolDetailFragmentArgs
import com.example.basisscholengent.databinding.FragmentScholenDetailBinding
import com.example.basisscholengent.viewmodels.SchoolDetailViewModel

class SchoolDetailFragment : Fragment() {
    val arguments: SchoolDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentScholenDetailBinding.inflate(inflater,container,false)
        val viewModel = ViewModelProvider(this).get((SchoolDetailViewModel::class.java))

        //observeren zodat de wijzigingen ook aan ui worden door gegeven
        viewModel.school.observe(viewLifecycleOwner, Observer {
            binding.school =it
        })
        //object doorgeven aan viewmodel
        viewModel.updateSchool(arguments.school)

        return  binding.root
    }
}