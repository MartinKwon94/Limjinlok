package com.example.limjinlok

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfo (val userTitle: String, val userDetail: String) : Parcelable