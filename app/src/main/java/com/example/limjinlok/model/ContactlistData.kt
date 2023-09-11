package com.example.limjinlok.model

import GridData
import android.os.Parcelable
import com.example.limjinlok.model.UserDataModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactListData(
    val userImage: Int,
    var isFavorite :Boolean = false,
    val userData: ArrayList<UserDataModel>,
    val gridItemData: GridData? = null
) : Parcelable