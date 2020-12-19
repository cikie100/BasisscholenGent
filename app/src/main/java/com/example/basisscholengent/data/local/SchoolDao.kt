package com.example.basisscholengent.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SchoolDao {

    //get all scholen
    @Transaction
    @Query("select * from scholen ORDER BY naam")
    fun getAllScholen():LiveData<List<SchoolEntity>>

    //get all school by id
    @Transaction
    @Query("select * from scholen where recordid=:id")
    fun getSchool(id: String): LiveData<SchoolEntity>

    //scholen toevoegen aan db, worden vervangen
    //geen replace is bv als iemand met hetzelfde email probeert te registreren
   @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun insertAll(list: List<SchoolEntity>)
}