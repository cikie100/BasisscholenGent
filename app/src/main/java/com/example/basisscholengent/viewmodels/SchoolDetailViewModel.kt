package com.example.basisscholengent.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basisscholengent.data.local.SchoolEntity
import com.example.basisscholengent.models.School
import com.example.basisscholengent.repos.SchoolRepository


class SchoolDetailViewModel(private val repository: SchoolRepository) : ViewModel() {
    private lateinit var _school :  LiveData<SchoolEntity>
    val school: LiveData<SchoolEntity>
        get() = _school

    fun updateSchool(id: String){
        _school = repository.getSchool(id)
    }
}