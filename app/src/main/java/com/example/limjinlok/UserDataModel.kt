package com.example.limjinlok

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserDataModel(
    val name: String,
    val content : String,
): Parcelable
