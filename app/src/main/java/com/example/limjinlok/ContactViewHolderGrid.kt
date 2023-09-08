package com.example.limjinlok

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ContactViewHolderGrid(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val gr_profileImage: ImageView = itemView.findViewById(R.id.ProfileImggrid)
    val gr_tv_name: TextView = itemView.findViewById(R.id.tv_namegrid)
    val gr_tv_nickname: TextView = itemView.findViewById(R.id.tv_nicknamegrid)
}