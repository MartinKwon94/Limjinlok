package com.example.limjinlok.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactListData(
    val userImage: Int,
    val isFavorite: Boolean = false,
    val userData: ArrayList<UserDataModel>,
) : Parcelable