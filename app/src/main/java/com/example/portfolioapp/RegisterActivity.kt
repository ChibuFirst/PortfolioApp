package com.example.portfolioapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    companion object {
        const val SHARED_PREFERENCE = "com.example.portfolioapp.sharedPreference"
        const val NAME = "NAME"
        const val EMAIL = "EMAIL"
        const val PHONE = "PHONE"
        const val PASSWORD = "PASSWORD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        button_register.setOnClickListener {
            validateInputs()
        }
    }

    private fun validateInputs() {
        when {
            TextUtils.isEmpty(edit_name.text) -> {
                edit_name.error = "Field Required."
            }
            TextUtils.isEmpty(edit_email_address.text) -> {
                edit_email_address.error = "Field Required."
            }
            TextUtils.isEmpty(edit_phone.text) -> {
                edit_phone.error = "Field Required."
            }
            TextUtils.isEmpty(edit_password.text) -> {
                edit_password.error = "Field Required."
            }
            else -> {
                saveDetails()
            }
        }
    }

    private fun saveDetails() {
        val sharedPreference = getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putString(NAME, edit_name.text.toString())
        editor.putString(EMAIL, edit_email_address.text.toString())
        editor.putString(PHONE, edit_phone.text.toString())
        editor.putString(PASSWORD, edit_password.text.toString())
        editor.apply()

        startActivity(Intent(this, LoginActivity::class.java))
    }
}
