package com.example.basisscholengent.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//versie nodig om te weten waarmee bestaande gebruikers werken, 2de versie kan nieuwe tabellen bevatten
//exportSchema== om db om te zetten naar json file, gebruiken voor testen
@Database(entities = [SchoolEntity::class], version = 1, exportSchema= false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun schoolDao(): SchoolDao

    companion object{
        @Volatile private var instance:AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase =
                //als niet bestaat dan aanmaken
                instance ?: synchronized(this){ instance?: buildDatabase(context).also{ instance=it}}

        private fun buildDatabase(appContext: Context)=
                Room.databaseBuilder(appContext,AppDatabase::class.java,"SchoolDB")
                        .fallbackToDestructiveMigration().build()
    }

}