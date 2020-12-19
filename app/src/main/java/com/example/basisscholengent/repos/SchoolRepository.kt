package com.example.basisscholengent.repos

import androidx.lifecycle.MutableLiveData
import com.example.basisscholengent.data.local.ScholenLocalDataSource
import com.example.basisscholengent.data.remote.ScholenRemoteDataSource
import com.example.basisscholengent.utils.performGetOperation

//remote en local source nodig

class SchoolRepository(
    private val scholenLocalDataSource: ScholenLocalDataSource,
    private val scholenRemoteDataSource: ScholenRemoteDataSource
) {


    fun getSchool(id: String) = scholenLocalDataSource.getSchool(id)

    //als we lijst opvragen, eerst api vragen, ...
     fun getScholen() = performGetOperation(
        databaseQuery = {scholenLocalDataSource.getScholen()},
           networkCall = {scholenRemoteDataSource.getScholen()},
                saveCallResult = {scholenLocalDataSource.saveScholen(it.records)}
    )


}