package com.example.aboutme

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.aboutme.databinding.ActivityMainBinding

data class MyName(var name: String = "", var nickname: String = "")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val myName = MyName("Fedor Blagodyr")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.action_bar)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.myName = myName
        binding.editButton.setOnClickListener { changeNickname() }
        setContentView(binding.root)
    }

    private fun changeNickname() {
        binding.nicknameEdit.visibility = GONE
        binding.editButton.visibility = GONE
        myName.nickname = binding.nicknameEdit.text.toString()
        binding.nicknameText.text = binding.nicknameEdit.text
        binding.nicknameText.visibility = VISIBLE
        // Invalidate all binding expressions and request a new rebind to refresh UI
        binding.invalidateAll()
    }
}