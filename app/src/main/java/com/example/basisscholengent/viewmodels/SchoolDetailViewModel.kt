package com.example.basisscholengent.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basisscholengent.models.School


class SchoolDetailViewModel : ViewModel() {
    private var _school = MutableLiveData<School>()
    val school: LiveData<School>
        get() = _school

    fun updateSchool(school: School){
        _school.value = school
    }
}