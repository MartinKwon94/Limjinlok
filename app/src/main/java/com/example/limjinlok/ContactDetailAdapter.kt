package com.example.limjinlok

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.databinding.ItemPageBinding
import com.example.limjinlok.model.ContactListData
import com.example.limjinlok.model.UserDataModel

class ContactDetailAdapter(private val items: ContactListData) :
    RecyclerView.Adapter<ContactDetailAdapter.Holder>() {


    //아이템 레이아웃을 return
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int = items.userData.size

    //데이터를 넣어줌
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = items.userData[position].name
        holder.detail.text = items.userData[position].content
    }

    inner class Holder(binding: ItemPageBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvTitle
        val detail = binding.tvDetail
    }
}