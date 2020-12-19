package com.example.basisscholengent.repos

import android.content.Context
import com.example.basisscholengent.data.local.AppDatabase
import com.example.basisscholengent.data.local.ScholenLocalDataSource
import com.example.basisscholengent.data.remote.GhentApi
import com.example.basisscholengent.data.remote.ScholenRemoteDataSource

class RepositoryUtils {
    //klasse om scholenrepository aan te maken
    companion object{
        fun createScholenRepository(context: Context) :SchoolRepository{
            val database = AppDatabase.getDatabase(context)
            val localDataSource= ScholenLocalDataSource(database.schoolDao())
            val remoteDataSource= ScholenRemoteDataSource(GhentApi.apiService)

            return SchoolRepository(localDataSource, remoteDataSource)
        }
    }
}