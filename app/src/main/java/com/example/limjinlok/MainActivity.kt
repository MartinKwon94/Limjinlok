package com.example.limjinlok

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.limjinlok.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataList = mutableListOf<ContactListData>()
    private val mainViewPagerAdapter by lazy { MainViewPagerAdapter(this@MainActivity) }

    private var rainbow = GradientDrawable(
        GradientDrawable.Orientation.TL_BR,
        intArrayOf(
            Color.RED,
            Color.MAGENTA,
            Color.BLUE,
            Color.CYAN,
            Color.GREEN,
            Color.YELLOW,
            Color.RED,
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        initView()
        viewPagerChanged()
    }

    private fun initData() {
        addUser(R.drawable.martinkwon, "권민석", "권마틴", "", "", "","")
//        dataList.add(addUser(R.drawable.ryu, "류연주", "류", false))
//        dataList.add(addUser(R.drawable.limyo, "임요환", "테란의 황제", false))
//        dataList.add(addUser(R.drawable.jigaebot, "조병현", "지게로봇", false))
//        dataList.add(addUser(R.drawable.leejamong, "홍현민", "에펙하쉴", false))
//        dataList.add(addUser(R.drawable.hongjin, "홍진호", "저그의 황제", false))
//        dataList.add(addUser(R.drawable.cookiemonster, "황일규", "쿠키몬스커", false))
//        dataList.add(addUser(R.drawable.tom, "Tom", "Spiderman", false))
//        dataList.add(addUser(R.drawable.tim, "Timothée", "Tim", false))
//        dataList.add(addUser(R.drawable.zen, "Zendaya", "Zen", false))
//        dataList.add(addUser(R.drawable.ash, "한지우", "지우", false))
//        dataList.add(addUser(R.drawable.garyoak, "오바람", "재수탱", false))
    }

    private fun viewPagerChanged() = with(binding) {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val nFragment = mainViewPagerAdapter.getFragmentByIndex(position)
                if (nFragment is ContactlistFragment) {
                    addContactButton.show()

                } else {
                    addContactButton.hide()
                }
            }
        })
    }

    private fun initView() = with(binding) {
        mainViewPagerAdapter.addTabList(
            ContactlistFragment.newInstance(ArrayList(dataList)),
            "Contact"
        )
        mainViewPagerAdapter.addTabList(MyPageFragment(), "My Page")
        viewPager.adapter = mainViewPagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            tab.text = mainViewPagerAdapter.getTitleByIndex(pos)
        }.attach()
    }

    private fun addUser(
        image: Int,
        name: String,
        nickName: String,
        contact: String,
        blogUrl: String,
        email: String,
        comment: String,
        isFavorite: Boolean = false,
    ) {
        val userData = ArrayList<UserDataModel>()
        userData.add(UserDataModel("이름", name))
        userData.add(UserDataModel("별명", nickName))
        userData.add(UserDataModel("연락처", contact))
        userData.add(UserDataModel("블로그", blogUrl))
        userData.add(UserDataModel("이메일", email))
        userData.add(UserDataModel("한마디", comment))
        dataList.add(ContactListData(image, isFavorite, userData))
    }

}