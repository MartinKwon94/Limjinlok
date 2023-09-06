package com.example.limjinlok

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactInfo (val cdTitle: String, val cdDetail: String) :Parcelable