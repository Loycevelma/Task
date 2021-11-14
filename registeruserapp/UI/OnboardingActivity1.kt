package com.example.registeruserapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.registeruserapp.databinding.ActivityOnboarding1Binding

class OnboardingActivity1 : AppCompatActivity() {
    lateinit var binding:ActivityOnboarding1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOnboarding1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent= Intent(this@OnboardingActivity1, OnboardingActivity2::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}