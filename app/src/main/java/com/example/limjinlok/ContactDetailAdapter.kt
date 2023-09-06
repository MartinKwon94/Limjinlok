package com.example.limjinlok

import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.databinding.PageItemBinding

class ContactDetailAdapter (private val mItems: MutableList<ContactInfo>) : RecyclerView.Adapter<ContactDetailAdapter.Holder>() {



    inner class Holder(binding: PageItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvTitle
        val detail = binding.tvDetail


    }
}