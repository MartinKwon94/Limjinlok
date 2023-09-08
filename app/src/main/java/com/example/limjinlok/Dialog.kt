package com.example.limjinlok

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
                val name = alert.findViewById<EditText>(R.id.Name)?.text.toString()
                val nickname = alert.findViewById<EditText>(R.id.NickName)?.text.toString()
                val number = alert.findViewById<EditText>(R.id.Number)?.text.toString()
                val email = alert.findViewById<EditText>(R.id.Email)?.text.toString()
                val extra1 = alert.findViewById<EditText>(R.id.Extra1)
                val extra2 = alert.findViewById<EditText>(R.id.Extra2)

                if(name.isNotBlank() && number.isNotBlank()) {


                    //위에서 설정된 값을 각각 이미지와 텍스트로 적용하기
                    //testimage, testarea는 둘 다 잘 작동하는지 시험용으로 MainActivity에 만든 이미지뷰, 텍스트뷰 입니다
                    //val testimage = findViewById<ImageView>(R.id.ImageTest)
                    //val testarea = findViewById<TextView>(R.id.testarea)


                    //연락처 추가때 사용한 이미지를 적용하기(현재 샘플이미지로 처리)
                    //testimage.setImageResource(R.drawable.sample)
                    //testarea.text = name + nickname + number + email + "${extra1?.text}" + "${extra2?.text}"
                    //TestArea.append(" / 나이 : ${edit2?.text}")
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
}