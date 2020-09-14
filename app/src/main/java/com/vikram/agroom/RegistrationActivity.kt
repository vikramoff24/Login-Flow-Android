package com.vikram.agroom

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class RegistrationActivity : AppCompatActivity() {

    lateinit var etName: EditText
    lateinit var etEmailAddress: EditText
    lateinit var etMobileNumber: EditText
    lateinit var etDeliveryAddress: EditText
    lateinit var etPassword: EditText
    lateinit var etConfrimPassword: EditText
    lateinit var btnRegister: Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var imgBack:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences=getSharedPreferences(getString(R.string.Preferences_file_name), Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        etName = findViewById(R.id.etName)
        etEmailAddress = findViewById(R.id.etEmailAddress)
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etDeliveryAddress = findViewById(R.id.etDeliveryAddress)
        etPassword = findViewById(R.id.etPassword)
        etConfrimPassword = findViewById(R.id.etConfrimPassword)
        btnRegister = findViewById(R.id.btnRegister)
        imgBack=findViewById(R.id.imgBack)
        imgBack.setOnClickListener {
            val intent= Intent(this@RegistrationActivity,LoginActivity::class.java)
            startActivity(intent)
        }
        btnRegister.setOnClickListener {
                    sharedPreferences.edit().putString("Name",etName.text.toString()).apply()
                    sharedPreferences.edit().putString("EmailAddress",etEmailAddress.text.toString()).apply()
                    sharedPreferences.edit().putString("MobileNumber", etMobileNumber.text.toString()).apply()
                    sharedPreferences.edit().putString("DeliveryAddress",  etDeliveryAddress.text.toString()).apply()
                    sharedPreferences.edit().putString("Password",  etPassword.text.toString()).apply()
                    sharedPreferences.edit().putString("ConfrimPassword", etConfrimPassword.text.toString()).apply()
            val intent= Intent(this@RegistrationActivity,InforegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}