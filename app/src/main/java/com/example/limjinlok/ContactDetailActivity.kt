package com.example.limjinlok

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.limjinlok.databinding.ActivityContactDetailBinding


class ContactDetailActivity : AppCompatActivity() {
    private var adapter = ContactDetailAdapter()

    private lateinit var binding: ActivityContactDetailBinding

    //데이터 원본 필요
//    private val data: 어댑터? by lazy {
//        arguments?.getParcelable<어댑터>
//    }
//    lateinit var receiveData: 어댑터


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cdRecyclerview.adapter = adapter
        binding.cdRecyclerview.layoutManager = LinearLayoutManager(this)
    }

}