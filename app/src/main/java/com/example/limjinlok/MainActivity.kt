package com.example.limjinlok

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.limjinlok.databinding.ActivityMainBinding
import com.example.limjinlok.databinding.DialogBinding
import com.example.limjinlok.model.ContactListData
import com.example.limjinlok.model.UserDataModel
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
        val dialbind = DialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initView()
        viewPagerChanged()

        //다이얼로그 부분
        binding.addContactButton.setOnClickListener {

            //플로팅버튼 클릭시 다이얼로그 시작
            val builder = AlertDialog.Builder(this)
            builder.setTitle("연락처 추가")

            val v1 = layoutInflater.inflate(R.layout.dialog, null)
            builder.setView(v1)

            val confirm = DialogInterface.OnClickListener { dialog1, dialog2 ->
                val alert = dialog1 as AlertDialog

                //이미지 값 설정
                //val sampleimage = alert.findViewById<ImageView>(R.id.SampleImage)
                val sampleimage = binding.root

                //EditText값 설정
                val name = alert.findViewById<EditText>(R.id.Name)?.text.toString()
                val nickName = alert.findViewById<EditText>(R.id.NickName)?.text.toString()
                val contact = alert.findViewById<EditText>(R.id.Number)?.text.toString()
                val blogUrl = alert.findViewById<EditText>(R.id.Extra1)?.text.toString()
                val email = alert.findViewById<EditText>(R.id.Email)?.text.toString()
                val comment = alert.findViewById<EditText>(R.id.Extra2)?.text.toString()

                //바인딩으로 교체
//                val name = dialbind.Name.text.toString()
//                val nickName = dialbind.NickName.text.toString()
//                val contact = dialbind.Number.text.toString()
//                val blogUrl = binding.root.toString()
//                val email = binding.root.toString()
//                val comment = binding.root.toString()

                if(name.isNotBlank() && contact.isNotBlank()) {

                    //위에서 설정된 값을 각각 이미지와 텍스트로 적용하기
                    //val testimage = findViewById<ImageView>(R.id.ImageTest)
                    //val testarea = findViewById<TextView>(R.id.testarea)



                    //ProfileImg.setImageResource(R.id.SampleImage)
                    //tv_name = name
                    //tv_nickname = nickName
                    Toast.makeText(this,name,Toast.LENGTH_SHORT).show()
                    val Plus = addUser(R.drawable.sample,name,nickName,contact,blogUrl,email,comment)



                }
                else{
                    //이름이나 번호에 공백이 있을시 입력값을 받지않고 다이얼로그가 종료됩니다
                    Toast.makeText(this,"이름과 번호는 필수입니다", Toast.LENGTH_SHORT).show()
                }
            }
            //다이얼로그 버튼 기능
            builder.setPositiveButton("확인", confirm)
            builder.setNegativeButton("취소", null)
            builder.show()
        }

    }

    private fun initData() {
        addUser(R.drawable.martinkwon, "권민석", "권마틴", "", "", "", "")
        addUser(R.drawable.limyo, "임요환", "테란의 황제", "", "", "", "")
        addUser(R.drawable.jigaebot, "조병현", "지게로봇", "", "", "", "")
        addUser(R.drawable.leejamong, "홍현민", "에펙하쉴", "", "", "", "")
        addUser(R.drawable.hongjin, "홍진호", "저그의 황제", "", "", "", "")
        addUser(R.drawable.cookiemonster, "황일규", "쿠키몬스커", "", "", "", "")
        addUser(R.drawable.tim, "Timothée", "Tim", "", "", "", "")
        addUser(R.drawable.zen, "Zendaya", "Zen", "", "", "", "")
        addUser(R.drawable.ash, "한지우", "지우", "", "", "", "")
        addUser(R.drawable.garyoak, "오바람", "재수탱", "", "", "", "")
    }

    private fun viewPagerChanged() = with(binding) {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                val nFragment = mainViewPagerAdapter.getFragmentByIndex(position)
                if (nFragment is ContactListFragment) {
                    addContactButton.show()

                } else {
                    addContactButton.hide()
                }
            }
        })
    }

    private fun initView() = with(binding) {
        mainViewPagerAdapter.addTabList(
            ContactListFragment.newInstance(ArrayList(dataList)),
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