package com.example.limjinlok.model

import android.os.Parcelable
import com.example.limjinlok.model.UserDataModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactListData(
    val userImage: Int,
    var isFavorite :Boolean = false,
    val userData: ArrayList<UserDataModel>,
) : Parcelable