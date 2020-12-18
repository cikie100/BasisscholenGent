package com.example.basisscholengent.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.basisscholengent.SchoolOverviewFragmentDirections
import com.example.basisscholengent.adapters.SchoolAdapter
import com.example.basisscholengent.adapters.SchoolClickListener
import com.example.basisscholengent.data.remote.GhentApi
import com.example.basisscholengent.databinding.FragmentScholenOverviewBinding
import com.example.basisscholengent.models.School
import com.example.basisscholengent.viewmodels.SchoolOverviewViewModel
import com.example.basisscholengent.viewmodels.SchoolOverviewViewModelFactory

class SchoolOverviewFragment : Fragment(), SchoolClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentScholenOverviewBinding.inflate(inflater, container, false)
        val factory = SchoolOverviewViewModelFactory(GhentApi.apiService)
        val viewModel = ViewModelProvider(this, factory).get(SchoolOverviewViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = SchoolAdapter(this)
        binding.adapter = adapter

        //lijst van scholen doorgeven aan adapter
        //haal lijst op
        //bij elke update wordt deze stuk uitgevoerd
        viewModel.scholen.observe(viewLifecycleOwner, Observer {
            //als wijzigingen, geef nieuwe lijst door aan adapter
            adapter.submitList(it)
        })

        return binding.root
    }

    override fun onSchoolClicked(school: School) {
        val directions =
                SchoolOverviewFragmentDirections.actionSchoolOverviewFragmentToSchoolDetailFragment(
                        school
                )
        findNavController().navigate(directions)
    }
}
