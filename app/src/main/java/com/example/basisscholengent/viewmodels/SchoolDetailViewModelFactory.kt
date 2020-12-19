package com.example.basisscholengent.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basisscholengent.repos.SchoolRepository


class SchoolDetailViewModelFactory(private val repository: SchoolRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //controle of type SchoolOverviewViewModel
        if (modelClass.isAssignableFrom(SchoolDetailViewModel::class.java)) {
            //nieuwe SchoolOverviewViewModel object creeeren
            //door apiservice door geven als parameter
            return SchoolDetailViewModel(repository) as T
        }
        //als niet van type SchoolOverviewViewModel dan exception
        throw IllegalArgumentException("Unknown Viewmodel class")
    }

}