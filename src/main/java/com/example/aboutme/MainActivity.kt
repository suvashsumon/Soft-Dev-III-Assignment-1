package com.example.aboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view : View)
    {
        val editText: EditText = findViewById(R.id.editText)
        var nickName: TextView = findViewById(R.id.nick_name)

        nickName.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nickName.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}