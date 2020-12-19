package com.example.basisscholengent.data.remote

import com.example.basisscholengent.data.BaseDateSource

class ScholenRemoteDataSource (private val apiService: GhentApiService): BaseDateSource() {
    //alle netwerk calls
    //tussenlaag repository en database

        suspend fun getScholen()=  getResult{apiService.getScholen()}
}