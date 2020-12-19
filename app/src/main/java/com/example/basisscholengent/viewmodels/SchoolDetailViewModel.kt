package com.example.basisscholengent.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.basisscholengent.data.local.SchoolEntity
import com.example.basisscholengent.repos.SchoolRepository


class SchoolDetailViewModel(private val repository: SchoolRepository) : ViewModel() {
    private lateinit var _school :  LiveData<SchoolEntity>
    val school: LiveData<SchoolEntity>
        get() {
            return _school
        }

    fun updateSchool(id: String): LiveData<SchoolEntity>{
        _school = repository.getSchool(id)
        return _school
    }


}