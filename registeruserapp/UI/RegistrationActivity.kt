package com.example.registeruserapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registeruserapp.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding

    lateinit var firebaseUser: FirebaseUser

    // firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistrationBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // this



            // initialise firebase
            auth = FirebaseAuth.getInstance()


            // click listener for layout
            binding.btnSignUpUser.setOnClickListener {

                var userName = binding.tvUserName.text.toString()
                var email = binding.tvEmail.text.toString()
                var password = binding.tvPassword.text.toString()
                var confirmPassword = binding.tvConfirmPassword.text.toString()
                var progressBar=binding.progressBar


                if (userName.isEmpty()) {
                    Toast.makeText(this, "FirstName can't be empty", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                if (email.isEmpty()) {
                    Toast.makeText(this, "Email can't be empty", Toast.LENGTH_LONG).show()
                    return@setOnClickListener

                }
                if (password.isEmpty()) {
                    Toast.makeText(this, "Password can't be empty", Toast.LENGTH_LONG).show()
                    return@setOnClickListener

                }
                if (confirmPassword.isEmpty()) {
                    Toast.makeText(this, "ConfirmPassword can't be empty", Toast.LENGTH_LONG).show()
                    return@setOnClickListener

                }

                if (password != confirmPassword) {
                    Toast.makeText(this, "Password not same", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            sendEmailVerification()
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        }
                    }
            }
            // click listener for layout
            binding.btnSignUpUser.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

        }


        private fun sendEmailVerification() {
            firebaseUser.let {
                it.sendEmailVerification().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"Email has been Sent to "+firebaseUser.email, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        override fun onStart() {
            super.onStart()
            val user: FirebaseUser? = auth.currentUser
            user?.let {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }


    }

