package com.example.basisscholengent.data.local

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scholen")
data class SchoolEntity (
        @PrimaryKey
        @ColumnInfo(name = "id")
        val recordid: String,
        val naam: String,
        val adres: String,

        @Nullable
        val telefoon: String= " ",
        @Nullable
        val email: String = " ",
        @Nullable
        val website: String = " ",
)