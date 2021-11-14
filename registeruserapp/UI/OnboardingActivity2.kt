package com.example.registeruserapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.registeruserapp.R
import com.example.registeruserapp.databinding.ActivityOnboarding2Binding

class OnboardingActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityOnboarding2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOnboarding2Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_onboarding2)
        setContentView(binding.root)
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent= Intent(this@OnboardingActivity2, PhoneNumberAuthentication::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}