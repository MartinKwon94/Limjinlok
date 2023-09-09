package com.example.limjinlok

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.limjinlok.databinding.ActivityContactDetailBinding
import com.example.limjinlok.model.ContactListData


class ContactDetailActivity : AppCompatActivity() {
    private val itemIndex by lazy {
        intent.getIntExtra("item_index", -1)
    }

    private val userData by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableExtra(
                "data",
                ContactListData::class.java
            )
        } else {
            intent?.getParcelableExtra<ContactListData>(
                "data"
            )
        }
    }
    private val adapter by lazy { userData?.let { ContactDetailAdapter(it) } }
    private lateinit var binding: ActivityContactDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cdRecyclerview.adapter = adapter
        binding.cdRecyclerview.layoutManager = LinearLayoutManager(this)
        userData?.let { binding.imageView.setImageResource(it.userImage) }
        Log.d("test", userData.toString())
        Log.d("test", itemIndex.toString())
    }

}