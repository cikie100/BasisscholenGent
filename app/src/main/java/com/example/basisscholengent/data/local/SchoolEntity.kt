package com.example.basisscholengent.data.local



import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scholen")
class SchoolEntity (
        @PrimaryKey
        @ColumnInfo(name = "recordid")
        val recordid: String,
        val naam: String,
        val adres: String,


        val telefoon: String= " ",
        val email: String = " ",
        val website: String = " "
)