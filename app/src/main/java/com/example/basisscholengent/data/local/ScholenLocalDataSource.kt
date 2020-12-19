package com.example.basisscholengent.data.local

import com.example.basisscholengent.models.School

class ScholenLocalDataSource (private val schoolDao: SchoolDao ){
    //alle database opperaties
    //tussenlaag repository en database

    //alles terug krijgen
    fun getScholen() = schoolDao.getAllScholen()

    //school zoeken op id
    fun getSchool(id:String) = schoolDao.getSchool(id)

    //opslaan in db
    fun saveScholen(list: List<School>){//we krijgen een lijst van scholen
        val scholenList = ArrayList<SchoolEntity>() //slaan we op als schoolEntity object
        list.forEach{ school -> scholenList.add(school.toDatabaseModel())} //omzetten en opslaan in nieuwe lijst
        schoolDao.insertAll(scholenList)//opslaan
    }
}