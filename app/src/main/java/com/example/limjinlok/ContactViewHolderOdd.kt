package com.example.limjinlok

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.databinding.ItemContactlistBinding
import com.example.limjinlok.databinding.ItemContactlistOddBinding
import com.example.limjinlok.model.ContactListData

class ContactViewHolderOdd (itemView: ItemContactlistOddBinding, val actions: (Int, ContactListData) -> Unit) : RecyclerView.ViewHolder(itemView.root) {
    val Od_profileImage: ImageView = itemView.ProfileImgodd
    val Od_tv_name: TextView = itemView.tvNameodd
    val Od_tv_nickname: TextView = itemView.tvNicknameodd
    val Od_favBut: ImageButton = itemView.btnFavodd
}
