package com.example.limjinlok

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.model.ContactListData

class ContactListAdapter(val mItems: ArrayList<ContactListData>) :
    RecyclerView.Adapter<ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contactlist, parent, false)
        return ContactViewHolder(view)

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item: ContactListData = mItems[position]

        holder.profileImage.setImageResource(item.userImage)
        holder.tv_name.text = item.userData[0].content
        holder.tv_nickname.text = item.userData[1].content
        holder.favBut.setOnClickListener {
            item.isFavorite =!item.isFavorite
            if (item.isFavorite)
                holder.favBut.setImageResource(R.drawable.staron)
            else
                holder.favBut.setImageResource(R.drawable.staroff)
        }
        if (item.userData[1].content.length > 4) {
            val shortenedText = item.userData[1].content.substring(0, 4) + "..."
            holder.tv_nickname.text = shortenedText

            // 클릭 이벤트 핸들러를 설정하여 전체 내용을 보이게 함
            holder.tv_nickname.setOnClickListener {
                holder.tv_nickname.text = item.userData[1].content
                holder.tv_nickname.setOnClickListener(null)
            }
        } else {
            holder.tv_nickname.text = item.userData[1].content
        }
        if (item.userData[0].content.length > 3) {
            val shortenedText = item.userData[0].content.substring(0, 3) + "..."
            holder.tv_name.text = shortenedText

            // 클릭 이벤트 핸들러를 설정하여 전체 내용을 보이게 함
            holder.tv_name.setOnClickListener {
                holder.tv_name.text = item.userData[0].content
                holder.tv_name.setOnClickListener(null)
            }
        } else {
            holder.tv_name.text = item.userData[0].content
        }

    }


    override fun getItemCount(): Int {
        return mItems.size
    }


}


