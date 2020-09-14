package com.vikram.agroom

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.net.Inet4Address

class ForgotpasswordActivity : AppCompatActivity() {
lateinit var etMobileNumber:EditText
    lateinit var etEmailAddress: EditText
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnNext:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences=getSharedPreferences(getString(R.string.Preferences_file_name),Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)
        etMobileNumber=findViewById(R.id.etMobileNumber)
        etEmailAddress=findViewById(R.id.etEmailAddress)
btnNext=findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            val intent= Intent(this@ForgotpasswordActivity,InfoforgotpasswordActivity::class.java)
            startActivity(intent)
            var MobileNumber = etMobileNumber.text.toString()
            var EmailAddress = etEmailAddress.text.toString()
            sharedPreferences.edit().putString("Mob", MobileNumber).apply()
            sharedPreferences.edit().putString("Em", EmailAddress).apply()
        }
    }
}
