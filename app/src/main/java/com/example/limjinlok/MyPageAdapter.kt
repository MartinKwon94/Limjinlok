package com.example.limjinlok

import androidx.recyclerview.widget.RecyclerView
import com.example.limjinlok.databinding.PageItemBinding

class MyPageAdapter (private val mItems: MutableList<UserInfo>) : RecyclerView.Adapter<MyPageAdapter.Holder>() {



    inner class Holder(binding: PageItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvTitle
        val detail = binding.tvDetail


    }
}