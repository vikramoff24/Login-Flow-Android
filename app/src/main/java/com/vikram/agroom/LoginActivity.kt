package com.vikram.agroom

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var etMobileNumber : EditText
    lateinit var etPassword : EditText
    lateinit var btnLogin : Button
    var validMobileNumber ="0123456789"
    var validPassword=arrayOf("vikram","syed","deepak")
    lateinit var sharedPreferences: SharedPreferences
    lateinit var txtForgotPassword:TextView
    lateinit var txtRegister:TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.Preferences_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.activity_login)
        etMobileNumber=findViewById(R.id.etMobileNumber)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btnLogin)
        txtForgotPassword=findViewById(R.id.txtForgotPassword)
        txtRegister=findViewById(R.id.txtRegister)
        txtRegister.setOnClickListener {
            val intent= Intent(this@LoginActivity,RegistrationActivity::class.java)
            startActivity(intent)
        }
        txtForgotPassword.setOnClickListener {
            val intent= Intent(this@LoginActivity,ForgotpasswordActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            val intent= Intent(this@LoginActivity,InfologinActivity::class.java)

            var mobileNumber = etMobileNumber.text.toString()
            var password=etPassword.text.toString()
            var isLoggedin=sharedPreferences.getBoolean("isloggedin",false)

            if(isLoggedin)
            {

                startActivity(intent)

            }
            var titleName:String ="vikram"
            if(validMobileNumber==mobileNumber)
            {
                when(password) {

                    validPassword[0] -> {

                        savePreferences(etMobileNumber.text.toString(),etPassword.text.toString(),titleName)
                        startActivity(intent)
                    }
                    validPassword[1] -> {
                        savePreferences(etMobileNumber.text.toString(),etPassword.text.toString(),titleName)
                        startActivity(intent)
                    }
                    validPassword[2] -> {
                        savePreferences(etMobileNumber.text.toString(),etPassword.text.toString(),titleName)
                        startActivity(intent)
                    }
                    else ->
                    {
                        Toast.makeText(this@LoginActivity,"Please Enter Correct Information !",Toast.LENGTH_LONG).show()
                    }


                }

            }
            else {
                Toast.makeText(
                    this@LoginActivity,
                    "Please Enter Correct Information !",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }
    fun savePreferences(MobileNumber:String,Password:String,title:String)
    {
        sharedPreferences.edit().putBoolean("isloggedIn",true).apply()
        sharedPreferences.edit().putString("Mob",MobileNumber).apply()
        sharedPreferences.edit().putString("Pass",Password).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}
