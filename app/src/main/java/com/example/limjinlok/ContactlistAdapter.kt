package com.example.limjinlok

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactlistAdapter(val mContext: Context, val mItems: MutableList<ContactlistData>) :
    RecyclerView.Adapter<ContactViewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewholder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_contactlist, parent, false)
        return ContactViewholder(view)
    }

    override fun onBindViewHolder(holder: ContactViewholder, position: Int) {
        val item: ContactlistData = mItems[position]

        holder.profileImage.setImageResource(item.ctPic)
        holder.tv_name.text = item.aName
        holder.tv_nickname.text = item.aNickname
        if(mItems[position].aFav)
            holder.favBut.setImageResource(R.drawable.staron)
        else
            holder.favBut.setImageResource(R.drawable.staroff)
    }



    override fun getItemCount(): Int {
        return mItems.size
    }
}


