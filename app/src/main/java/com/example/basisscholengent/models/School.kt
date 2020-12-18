package com.example.basisscholengent.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class School(
    val recordid: String,
    val fields: SchoolFields
) : Parcelable
