package com.example.registeruserapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.registeruserapp.databinding.ActivityPhoneNumberAuthenticationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_phone_number_authentication.*
import java.util.concurrent.TimeUnit


class PhoneNumberAuthentication : AppCompatActivity() {
    lateinit var binding:ActivityPhoneNumberAuthenticationBinding
    private lateinit var auth: FirebaseAuth
    private var storedVerificationId: String? = ""
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPhoneNumberAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = Firebase.auth

        FirebaseApp.initializeApp(this)

        binding.btnVerifyUser.setOnClickListener {
            startPhoneNumberVerification(etPhoneNumber!!.text.toString())
        }
       binding.btnRegister.setOnClickListener {
            verifyPhoneNumberWithCode(storedVerificationId, etEnterOTP!!.text.toString())
            startActivity(Intent(baseContext, RegistrationActivity::class.java))
        }

        callbacks= object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                Log.d(TAG, "onVerificationCompleted:$p0")
                signInWithPhoneAuthCredential(p0)

                startActivity(Intent(baseContext, RegistrationActivity::class.java))
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Log.w(TAG, "onVerification", p0)

                if (p0 is FirebaseTooManyRequestsException){
                    //invalid request
                }
                else if( p0 is FirebaseTooManyRequestsException){
                    //sms exceeded
                }
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                Log.d(TAG, "onCodeSent: $p0")
                storedVerificationId=p0
                resendToken=p1
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun startPhoneNumberVerification(phoneNumber:String){
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private  fun verifyPhoneNumberWithCode(verificationId: String?, code:String){

        val credential= PhoneAuthProvider.getCredential(verificationId!!,code)

        signInWithPhoneAuthCredential(credential)
    }

    private  fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential){
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this){ task->
                if (task.isSuccessful){
                    Log.d(TAG, "signInWithCredential:success")

                    val user=task.result?.user

                    updateUI()

                    Toast.makeText(this, "Welcome to Nougat Technologies:"+user, Toast.LENGTH_LONG).show()
                } else {
                    if (task.exception is FirebaseAuthInvalidCredentialsException){

                    }
                }

            }
    }

    private fun updateUI(user: FirebaseUser?=auth.currentUser){

    }

    companion object{
        private const val TAG = "SignUpActivity"
    }
}
















