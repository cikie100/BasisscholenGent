package com.example.basisscholengent.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.basisscholengent.adapters.SchoolAdapter
import com.example.basisscholengent.adapters.SchoolClickListener
import com.example.basisscholengent.data.local.SchoolEntity
import com.example.basisscholengent.databinding.FragmentScholenOverviewBinding
import com.example.basisscholengent.repos.RepositoryUtils
import com.example.basisscholengent.utils.Status
import com.example.basisscholengent.viewmodels.SchoolOverviewViewModel
import com.example.basisscholengent.viewmodels.SchoolOverviewViewModelFactory

class SchoolOverviewFragment : Fragment(), SchoolClickListener {
    private val loadingDialogFragment by lazy { LoadingFragment() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentScholenOverviewBinding.inflate(inflater, container, false)
        val factory = SchoolOverviewViewModelFactory(RepositoryUtils.createScholenRepository((requireContext())))
        val viewModel = ViewModelProvider(this, factory).get(SchoolOverviewViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = SchoolAdapter(this)
        binding.adapter = adapter

        //lijst van scholen doorgeven aan adapter
        //haal lijst op
        //bij elke update wordt deze stuk uitgevoerd
        viewModel.scholen.observe(viewLifecycleOwner, Observer {
            //als wijzigingen, geef nieuwe lijst door aan adapter
           it?.let { resource ->
               when(resource.status){
                   Status.SUCCESS->{
                       showProgress(false)
                       adapter.submitList(resource.data)
                   }
                   Status.LOADING->{
                       showProgress(true)
                   }
                   Status.ERROR->{
                       showProgress(false)
                   }
               }

           }
        })

        return binding.root
    }

    private fun showProgress(b:Boolean){
        if(b){
            if(!loadingDialogFragment.isAdded){
                loadingDialogFragment.show(requireActivity().supportFragmentManager,"loader")}
        }else{
            if(loadingDialogFragment.isAdded){
                loadingDialogFragment.dismissAllowingStateLoss()}

        }

    }

    override fun onSchoolClicked(school: SchoolEntity) {
        val directions =
                SchoolOverviewFragmentDirections
                    .actionSchoolOverviewFragmentToSchoolDetailFragment(
                        school.recordid
                )
        findNavController().navigate(directions)
    }
}
