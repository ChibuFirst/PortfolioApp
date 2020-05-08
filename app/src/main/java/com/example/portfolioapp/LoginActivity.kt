package com.example.portfolioapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    companion object {
        const val USER_NAME = "USER_NAME"
        const val USER_EMAIL = "USER_EMAIL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener {
            validateInputs()
        }
    }

    private fun validateInputs() {
        when {
            TextUtils.isEmpty(edit_email.text) -> {
                edit_email.error = "Field Required."
            }
            TextUtils.isEmpty(edit_pass.text) -> {
                edit_pass.error = "Field Required."
            }
            else -> {
                openPortfolio()
            }
        }
    }

    private fun openPortfolio() {
        val sharedPreferences = getSharedPreferences(RegisterActivity.SHARED_PREFERENCE, Context.MODE_PRIVATE)
        val name = sharedPreferences.getString(RegisterActivity.NAME, "Full name")
        val email = sharedPreferences.getString(RegisterActivity.EMAIL, "Email")
        val password = sharedPreferences.getString(RegisterActivity.PASSWORD, "Password")

        if (email.equals(edit_email.text.toString())) {
            if (password.equals(edit_pass.text.toString())) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(USER_NAME, name)
                intent.putExtra(USER_EMAIL, email)
                startActivity(intent)
            }
            else {
                edit_pass.error = "Incorrect Password"
            }
        }
        else {
            edit_email.error = "Invalid Email Address"
        }
    }
}
