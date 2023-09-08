package com.example.limjinlok

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.model.ContactListData

class ContactListAdapter(
    val mItems: ArrayList<ContactListData>,
    val actions: (Int, ContactListData) -> Unit
) :
    RecyclerView.Adapter<ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contactlist, parent, false)
        return ContactViewHolder(view, actions)

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item: ContactListData = mItems[position]

        holder.profileImage.setImageResource(item.userImage)
        holder.tv_name.text = item.userData[0].content
        holder.tv_nickname.text = item.userData[1].content
        if (mItems[position].isFavorite)
            holder.favBut.setImageResource(R.drawable.staron)
        else
            holder.favBut.setImageResource(R.drawable.staroff)
        holder.itemView.setOnClickListener {
            actions(position, item)
        }
    }


    override fun getItemCount(): Int {
        return mItems.size
    }


}


