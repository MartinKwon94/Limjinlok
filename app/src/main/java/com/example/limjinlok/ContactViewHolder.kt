package com.example.limjinlok

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.databinding.ItemContactlistBinding
import com.example.limjinlok.model.ContactListData


class ContactViewHolder(itemView: ItemContactlistBinding, val actions: (Int, ContactListData) -> Unit) : RecyclerView.ViewHolder(itemView.root) {
    val profileImage: ImageView = itemView.ProfileImg
    val tv_name: TextView = itemView.tvName
    val tv_nickname: TextView = itemView.tvNickname
    val favBut: ImageButton = itemView.btnFav
}