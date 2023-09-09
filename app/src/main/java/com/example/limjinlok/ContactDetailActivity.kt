package com.example.limjinlok

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.limjinlok.databinding.ActivityContactDetailBinding
import com.example.limjinlok.model.ContactListData


class ContactDetailActivity : AppCompatActivity() {
    private var adapter = ContactDetailAdapter()

    private lateinit var binding: ActivityContactDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getIntExtra("item_index", 0)
        intent.getExtras("userData", null)
        setResult(Activity.RESULT_OK, intent)

        binding.cdRecyclerview.adapter = adapter
        binding.cdRecyclerview.layoutManager = LinearLayoutManager(this)
    }

}