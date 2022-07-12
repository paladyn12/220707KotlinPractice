package com.example.a220707kotlinpractice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_java.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 마지막 에딧 텍스트 완료버튼은 Login() 함수를 호출
        et_age.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                Login(v)
                true
            } else false
        }

        // 불러오기, 앱이 시작할 때 저장된 정보를 불러와야 하므로 onCreate 함수 내에 입력
        var pref = this.getPreferences(0)
        et_email.setText(pref.getString("이메일",""))
        et_password.setText(pref.getString("비밀번호",""))
        et_name.setText(pref.getString("이름",""))
        et_age.setText(pref.getString("나이",""))

    }
    fun Login(v:View){
        // 키보드 숨기기
        var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken,0)

        // 입력정보
        if(et_email.text.toString() == "paladyn12@naver.com" && et_password.text.toString() == "xodhks11" && et_name.text.toString() == "김태완" &&
                et_age.text.toString() == "23"){
            Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show()
        //if(intent.hasExtra("이름")) tv_result.text = intent.getStringExtra("이름")+"님 환영합니다."

            setContentView(R.layout.activity_java)
            tv_result.text = "김태완님 환영합니다."

            // 저장하여 중복 입력 방지
            var editor = this.getPreferences(0).edit()
            editor.putString("이메일","paladyn12@naver.com").apply()
            editor.putString("비밀번호","xodhks11").apply()
            editor.putString("이름","김태완").apply()
            editor.putString("나이","23").apply()


        }
        else    Toast.makeText(this,"로그인 실패",Toast.LENGTH_SHORT).show()

    }
}
