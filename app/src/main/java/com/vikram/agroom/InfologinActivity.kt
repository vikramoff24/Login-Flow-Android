package com.vikram.agroom

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class InfologinActivity : AppCompatActivity() {
    lateinit var txtMobileNumber: TextView
    lateinit var txtPassword: TextView
    lateinit var sharedPreferences: SharedPreferences
    lateinit var imgBack: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences= getSharedPreferences(getString(R.string.Preferences_file_name), Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infologin)
        txtMobileNumber = findViewById(R.id.txtMobileNumber)
txtPassword=findViewById(R.id.txtPassword)
        txtMobileNumber.text = sharedPreferences.getString("Mob", "No Information to Display !")
        txtPassword.text = sharedPreferences.getString("Pass", "No Information to Display !")

        imgBack=findViewById(R.id.imgBack)
        imgBack.setOnClickListener {
            val intent= Intent(this@InfologinActivity,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
