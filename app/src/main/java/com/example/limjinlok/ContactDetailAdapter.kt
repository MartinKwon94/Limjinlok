package com.example.limjinlok

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.databinding.ItemPageBinding
import com.example.limjinlok.model.ContactListData

class ContactDetailAdapter() : RecyclerView.Adapter<ContactDetailAdapter.Holder>() {


    //아이템 레이아웃을 return
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return 100
    }

    //데이터를 넣어줌
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = "Moible"
        holder.detail.text = "111-1111-1111"
    }

    inner class Holder(binding: ItemPageBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvTitle
        val detail = binding.tvDetail
    }
}