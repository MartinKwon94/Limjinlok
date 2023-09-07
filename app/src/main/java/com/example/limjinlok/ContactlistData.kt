package com.example.limjinlok

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactlistData(
    val ctPic: Int,
    val aName: String,
    val aNickname:String,
    val aFav: Boolean
    ) : Parcelable