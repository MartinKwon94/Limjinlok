package com.example.limjinlok

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.databinding.ItemContactlistBinding
import com.example.limjinlok.databinding.ItemContactlistGridBinding
import com.example.limjinlok.model.ContactListData


class ContactViewHolderGrid(itemView: ItemContactlistGridBinding, val actions: (Int, ContactListData) -> Unit) : RecyclerView.ViewHolder(itemView.root) {
    val gr_profileImage: ImageView = itemView.ProfileImggrid
    val gr_tv_name: TextView = itemView.tvNamegrid
    val gr_tv_nickname: TextView = itemView.tvNicknamegrid
}