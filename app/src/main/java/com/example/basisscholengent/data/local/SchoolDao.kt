package com.example.basisscholengent.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.basisscholengent.models.School

@Dao
interface SchoolDao {
    //3 methodes nodig

    //get all scholen
    @Transaction
    @Query("select * from scholen ORDER BY naam")
    fun getAllScholen():LiveData<List<School>>

    //get all school by id
    @Transaction
    @Query("select * from scholen where id=:id")
    fun getSchool(id: String)

    //scholen toevoegen aan db, worden vervangen
    //geen replace is bv als iemand met hetzelfde email probeert te registreren
   @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun insertAll(list: List<SchoolEntity>)
}