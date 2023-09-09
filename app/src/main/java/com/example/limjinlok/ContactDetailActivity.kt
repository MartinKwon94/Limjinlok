package com.example.limjinlok

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.limjinlok.databinding.ActivityContactDetailBinding
import com.example.limjinlok.model.ContactListData


class ContactDetailActivity : AppCompatActivity() {
    private val adapter by lazy { userData?.let { ContactDetailAdapter(it) } }

    private lateinit var binding: ActivityContactDetailBinding

    private val itemIndex by lazy {
        intent.getIntExtra("item_index", -1)
    }

    private val userData by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableExtra(
                "userData",
                ContactListData::class.java
            )
        } else {
            intent?.getParcelableExtra<ContactListData>(
                "userData"
            )
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setResult(Activity.RESULT_OK, intent)

        binding.cdRecyclerview.adapter = adapter
        binding.cdRecyclerview.layoutManager = LinearLayoutManager(this)
    }

}