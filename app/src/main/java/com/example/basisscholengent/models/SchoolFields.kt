package com.example.basisscholengent.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SchoolFields(
    val naam: String,
    val adres: String,
    val telefoon: String= " ",
    val email: String = " ",
    val website: String = " ",

    ) : Parcelable
