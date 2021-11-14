package com.example.registeruserapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registeruserapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
            setContentView(binding.root)
//initializing firebase
            auth = FirebaseAuth.getInstance()

            // click listener for layout
            binding.btnLogin.setOnClickListener {

                val email = binding.tvEmail.text.toString()

                val password = binding.tvPassword.text.toString()

                if (email.isEmpty()) {
                    Toast.makeText(this, "Email can't be empty", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                if (password.isEmpty()) {
                    Toast.makeText(this, "Password can't be empty", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }


                // signin with firebase

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        run {
                            if (task.isSuccessful) {
                                val intent=Intent(baseContext, DisplayRegistrationInformation::class.java)
                                startActivity(intent)

                            }
                        }
                    }
            }
        }
    }
