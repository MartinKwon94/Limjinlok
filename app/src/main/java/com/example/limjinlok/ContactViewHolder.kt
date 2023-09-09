package com.example.limjinlok

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.model.ContactListData


class ContactViewHolder(itemView: View, val actions: (Int, ContactListData) -> Unit) : RecyclerView.ViewHolder(itemView) {
    val profileImage: ImageView = itemView.findViewById(R.id.ProfileImg)
    val tv_name: TextView = itemView.findViewById(R.id.tv_name)
    val tv_nickname: TextView = itemView.findViewById(R.id.tv_nickname)
    val favBut: ImageButton = itemView.findViewById(R.id.btn_fav)
}