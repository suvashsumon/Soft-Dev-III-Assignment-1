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
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val nickName:NickName = NickName("Suvash Kumar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = nickName
//        val btn: Button = findViewById(R.id.button)
//        btn.setOnClickListener {
//            addNickName(it)
//        }
        binding.button.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view : View)
    {
        binding.apply {
            invalidateAll()
            //binding.nickName.text = binding.editText.text
            myName?.mynickname = editText.text.toString()
            binding.editText.visibility = View.GONE
            binding.button.visibility = View.GONE
            binding.nickName.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}