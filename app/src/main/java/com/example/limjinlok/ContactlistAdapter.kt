package com.example.limjinlok

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactlistAdapter(val mItems: ArrayList<ContactListData>) :
    RecyclerView.Adapter<ContactViewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contactlist, parent, false)
        return ContactViewholder(view)

    }

    override fun onBindViewHolder(holder: ContactViewholder, position: Int) {
        val item: ContactListData = mItems[position]

        holder.profileImage.setImageResource(item.userImage)
        holder.tv_name.text = item.userData[0].content
        holder.tv_nickname.text = item.userData[1].content
        if(mItems[position].isFavorite)
            holder.favBut.setImageResource(R.drawable.staron)
        else
            holder.favBut.setImageResource(R.drawable.staroff)
    }



    override fun getItemCount(): Int {
        return mItems.size
    }


}


