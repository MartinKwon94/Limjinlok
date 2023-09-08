package com.example.limjinlok.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserDataModel(
    val name: String,
    val content: String,
) : Parcelable
