package com.example.basisscholengent.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basisscholengent.repos.SchoolRepository

//api service wordt doorgegeven
//voor een object meegeven aan viewModel
class SchoolOverviewViewModelFactory(private val repository: SchoolRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //controle of type SchoolOverviewViewModel
        if (modelClass.isAssignableFrom(SchoolOverviewViewModel::class.java)) {
            //nieuwe SchoolOverviewViewModel object creeeren
            //door apiservice door geven als parameter
            return SchoolOverviewViewModel(repository) as T
        }
        //als niet van type SchoolOverviewViewModel dan exception
        throw IllegalArgumentException("Unknown Viewmodel class")
    }

}