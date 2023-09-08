package com.example.limjinlok

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactViewHolderOdd (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val Od_profileImage: ImageView = itemView.findViewById(R.id.ProfileImgodd)
    val Od_tv_name: TextView = itemView.findViewById(R.id.tv_nameodd)
    val Od_tv_nickname: TextView = itemView.findViewById(R.id.tv_nicknameodd)
    val Od_favBut: ImageButton = itemView.findViewById(R.id.btn_favodd)
}
}