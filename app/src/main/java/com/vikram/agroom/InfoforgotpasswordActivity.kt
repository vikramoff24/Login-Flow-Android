package com.vikram.agroom

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class InfoforgotpasswordActivity : AppCompatActivity() {
    lateinit var txtMobileNumber: TextView
    lateinit var txtEmailAddress: TextView
    lateinit var sharedPreferences: SharedPreferences
    lateinit var imgBack: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences=getSharedPreferences(getString(R.string.Preferences_file_name), Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infoforgotpassword)
        txtMobileNumber=findViewById(R.id.txtMobileNumber)
        txtEmailAddress=findViewById(R.id.txtEmailAddress)
        txtMobileNumber = findViewById(R.id.txtMobileNumber)

        imgBack=findViewById(R.id.imgBack)
        imgBack.setOnClickListener {
            val intent= Intent(this@InfoforgotpasswordActivity,ForgotpasswordActivity::class.java)
            startActivity(intent)
        }
        txtMobileNumber.text = sharedPreferences.getString("Mob", "No Information to Display !")
        txtEmailAddress.text = sharedPreferences.getString("Em", "No Information to Display !")
    }
}
