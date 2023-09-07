package com.example.limjinlok

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.limjinlok.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val dataList = mutableListOf<ContactlistData>()
    private val adapter = ContactlistAdapter(this, dataList)

    private var rainbow = GradientDrawable(
        GradientDrawable.Orientation.TL_BR,
        intArrayOf(
            Color.RED,
            Color.MAGENTA,
            Color.BLUE,
            Color.CYAN,
            Color.GREEN,
            Color.YELLOW,
            Color.RED
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.background = rainbow

        dataList.add(ContactlistData(R.drawable.martinkwon,"권민석","권마틴", false ))
        dataList.add(ContactlistData(R.drawable.ryu,"류연주","류",false))
        dataList.add(ContactlistData(R.drawable.limyo,"임요환","테란의 황제",false))
        dataList.add(ContactlistData(R.drawable.jigaebot,"조병현","지게로봇", false))
        dataList.add(ContactlistData(R.drawable.leejamong,"홍현민","에펙하쉴", false))
        dataList.add(ContactlistData(R.drawable.hongjin,"홍진호","저그의 황제", false))
        dataList.add(ContactlistData(R.drawable.cookiemonster,"황일규","쿠키몬스커",false))
        dataList.add(ContactlistData(R.drawable.tom,"Tom","Spiderman", false))
        dataList.add(ContactlistData(R.drawable.tim,"Timothée","Tim", false))
        dataList.add(ContactlistData(R.drawable.zen,"Zendaya","Zen", false))
        dataList.add(ContactlistData(R.drawable.ash,"한지우","지우", false))
        dataList.add(ContactlistData(R.drawable.garyoak,"오바람","재수탱", false))

        val bundle = Bundle()
        bundle.putParcelableArrayList("dataList", ArrayList(dataList))

        val contactlist = ContactlistFragment
        contactlist.arguments = bundle








    }
}