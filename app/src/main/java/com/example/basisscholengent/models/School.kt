package com.example.basisscholengent.models

import android.os.Parcelable
import com.example.basisscholengent.data.local.SchoolEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class School(
    val recordid: String,
    val fields: SchoolFields
) : Parcelable {
    fun toDatabaseModel(): SchoolEntity{
        return SchoolEntity(
            recordid
            , fields.naam
            , fields.adres
            ,fields.telefoon
            ,fields.email
            ,fields.website
        )
    }
}
