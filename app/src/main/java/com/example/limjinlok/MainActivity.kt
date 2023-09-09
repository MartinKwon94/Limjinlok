package com.example.limjinlok

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Menu
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
        setContentView(binding.root)
        initData()
        initView()
        viewPagerChanged()

        //플로팅버튼 클릭시 다이얼로그 시작
        binding.addContactButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("연락처 추가")

            val dialogBinding = DialogBinding.inflate(layoutInflater)
            builder.setView(dialogBinding.root)

            val confirm = DialogInterface.OnClickListener { dialog1, dialog2 ->
                val alert = dialog1 as AlertDialog

                //EditText값 설정
                val name = dialogBinding.Name.text.toString()
                val nickName = dialogBinding.NickName.text.toString()
                val contact = dialogBinding.Number.text.toString()
                val blogUrl = dialogBinding.Extra1.text.toString()
                val email = dialogBinding.Email.text.toString()
                val comment = dialogBinding.Extra2.text.toString()

                if (name.isNotBlank() && contact.isNotBlank()) {
                    Toast.makeText(this, "추가 완료!", Toast.LENGTH_SHORT).show()
                    addUser(R.drawable.sample, name, nickName, contact, blogUrl, email, comment)
                    updateList()
                } else {
                    //이름이나 번호에 공백이 있을시 입력값을 받지않고 다이얼로그가 종료
                    Toast.makeText(this, "이름과 번호는 필수입니다", Toast.LENGTH_SHORT).show()
                }
            }
            //다이얼로그 버튼 기능
            builder.setPositiveButton("확인", confirm)
            builder.setNegativeButton("취소", null)
            builder.show()
        }
    }


    private fun initData() {
        addUser(R.drawable.martinkwon, "권민석", "권마틴", "", "", "", "성시경을 먹으면? 위장 내 시경")
        addUser(R.drawable.ryu, "류연주", "류", "", "", "", "공기를 먹고 커지면? 에어로빅")
        addUser(R.drawable.limyo, "임요환", "테란의 황제", "", "", "", "곰돌이 푸가 차에 치이면? 카푸치노")
        addUser(R.drawable.jigaebot, "조병현", "지게로봇", "", "", "", "입이 S 모양인 사람은? EBS")
        addUser(R.drawable.leejamong, "홍현민", "에펙하쉴", "", "", "", "소가 번개에 맞아 죽으면? 우사인볼트")
        addUser(R.drawable.hongjin, "홍진호", "저그의 황제", "", "", "", "오리를 생으로 먹으면? 회오리")
        addUser(R.drawable.cookiemonster, "황일규", "쿠키몬스터", "", "", "", "누룽지를 영어로 하면? 바비브라운")
        addUser(R.drawable.tom, "Tom", "Spiderman", "", "", "", "손가락은 영어로 핑, 주먹은 뭐게요? 오므린거")
        addUser(R.drawable.tim, "Timothée", "Tim", "", "", "", "오리가 하늘을 날면서 요리가 되면? 푸드덕")
        addUser(R.drawable.zen, "Zendaya", "Zen", "", "", "", "강아지가 한 마리만 있는 나라는? 독일")
        addUser(R.drawable.ash, "한지우", "지우", "", "", "", "신데렐라가 못자면? 못짜렐라")
        addUser(R.drawable.garyoak, "오바람", "재수탱", "", "", "", "곰이 사과를 먹는 방법? 베어 먹지")
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
        mainViewPagerAdapter.addTabList(MyPageFragment.newInstance(ArrayList(dataList)), "My Page")
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

    private fun updateList() {
        val contactListFragment = mainViewPagerAdapter.getFragmentByIndex(0) as? ContactListFragment
        contactListFragment?.updateData(ArrayList(dataList))
    }

}