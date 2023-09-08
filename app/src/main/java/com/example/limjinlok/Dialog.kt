package com.example.limjinlok

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.limjinlok.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Dialog : AppCompatActivity() {

    //바인딩으로 코드 짤 경우 해당 문구 사용
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @SuppressLint("MissingInflatedId", "SetTextI18n", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val btn = findViewById<FloatingActionButton>(R.id.add_contact_button)
        binding.addContactButton.setOnClickListener {

            //플로팅버튼 클릭시 다이얼로그 시작
            val builder = AlertDialog.Builder(this)
            builder.setTitle("연락처 추가")

            val v1 = layoutInflater.inflate(R.layout.dialog, null)
            builder.setView(v1)

            val confirm = DialogInterface.OnClickListener { dialog1, dialog2 ->
                val alert = dialog1 as AlertDialog

                //이미지 값 설정
                val sampleimage = alert.findViewById<ImageView>(R.id.SampleImage)

                //EditText값 설정
                val name = alert.findViewById<EditText>(R.id.Name)
                val nickname = alert.findViewById<EditText>(R.id.NickName)
                val number = alert.findViewById<EditText>(R.id.Number)
                val email = alert.findViewById<EditText>(R.id.Email)
                val extra1 = alert.findViewById<EditText>(R.id.Extra1)
                val extra2 = alert.findViewById<EditText>(R.id.Extra2)

                //위에서 설정된 값을 각각 이미지와 텍스트로 적용하기
                //val testimage = findViewById<ImageView>(R.id.ImageTest)
                //val testarea = findViewById<TextView>(R.id.testarea)

                //연락처 추가때 사용한 이미지를 적용하기(현재 샘플이미지로 처리)
                //testimage.setImageResource(R.drawable.sample)
                //testarea.text = "${name?.text}" + "${nickname?.text}" + "${number?.text}" + "${email?.text}" + "${extra1?.text}" + "${extra2?.text}"

                //TestArea.append(" / 나이 : ${edit2?.text}")
            }

            //다이얼로그 버튼 기능
            builder.setPositiveButton("확인", confirm)
            builder.setNegativeButton("취소", null)

            builder.show()
        }

    }
}