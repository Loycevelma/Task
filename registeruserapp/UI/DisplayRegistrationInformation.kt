package com.example.registeruserapp.UI

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.registeruserapp.R
import com.example.registeruserapp.databinding.ActivityDisplayRegistrationInformationBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.auth.User

class DisplayRegistrationInformation : AppCompatActivity() {
    lateinit var binding:ActivityDisplayRegistrationInformationBinding

    //    private lateinit var auth: FirebaseAuth
    //    private lateinit var databaseReference: DatabaseReference
//    private lateinit var storageReference:StorageReference
//    private lateinit var dialog: Dialog
//    private lateinit var user: User
//    private lateinit var uid: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityDisplayRegistrationInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val intent= Intent(this@DisplayRegistrationInformation, HomeScreenActivity::class.java)
            startActivity(intent)
        }

//        auth.FirebaseAuth.getInstance()
//        uid=currentUser?.uid.toString()
//
//        databaseReference=firebaseDatabase.getInstance().getReference("Users")
//        if(uid.isNotEmpty()){
//            getUserData()
//        }
//        fun getUserData(){
//            databaseReference.child(uid).addValueEventListener(object : ValueEventListener)
//            Override fun OnDataChange(snapshot: DataSnapshot){
//                user=snapshot.getValue(User::class.java)!!
//
//                binding.tvEmail.setText(User.email)
//                binding.tvPassword.setText(User.password)
//

            }

        }










