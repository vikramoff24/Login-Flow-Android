package com.vikram.agroom

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class InforegistrationActivity : AppCompatActivity() {


    lateinit var txtName: TextView
    lateinit var txtEmailAddress: TextView
    lateinit var txtMobileNumber: TextView
    lateinit var txtDeliveryAddress: TextView
    lateinit var txtPassword: TextView
    lateinit var txtConfrimPassword: TextView
lateinit var imgBack:ImageView
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences=getSharedPreferences(getString(R.string.Preferences_file_name), Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inforegistration)
        txtName = findViewById(R.id.txtName)
        txtEmailAddress = findViewById(R.id.txtEmailAddress)
        txtMobileNumber = findViewById(R.id.txtMobileNumber)
        txtDeliveryAddress = findViewById(R.id.txtDeliveryAddress)
        txtPassword = findViewById(R.id.txtPassword)
        txtConfrimPassword = findViewById(R.id.txtConfrimPassword)

        imgBack=findViewById(R.id.imgBack)
        imgBack.setOnClickListener {
            val intent= Intent(this@InforegistrationActivity,RegistrationActivity::class.java)
            startActivity(intent)
        }

        txtName.text = sharedPreferences.getString("Name", "No Information to Display !")
        txtEmailAddress.text = sharedPreferences.getString("EmailAddress", "No Information to Display !")
        txtMobileNumber.text = sharedPreferences.getString("MobileNumber", "No Information to Display !")
        txtDeliveryAddress.text = sharedPreferences.getString("DeliveryAddress", "No Information to Display !")
        txtPassword.text = sharedPreferences.getString("Password", "No Information to Display !")
        txtConfrimPassword.text=sharedPreferences.getString("ConfrimPassword", "No Information to Display !")
    }
}
