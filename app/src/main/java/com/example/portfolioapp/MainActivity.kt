package com.example.portfolioapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val TAG = "MyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = intent.getStringExtra(LoginActivity.USER_NAME)
        val email = intent.getStringExtra(LoginActivity.USER_EMAIL)

        text_full_name.text = name
        text_email_address.text = email

        text_mail.setOnClickListener {
            val mailIntent = Intent(Intent.ACTION_SEND)
            mailIntent.data = Uri.parse("mailto:chibuzoonuoha57@gmail.com")
            mailIntent.type = "message/rfc822"
            startActivity(mailIntent)
        }

        text_github.setOnClickListener {
            val gitHubIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/chibufirst?tab=repositories"))
            startActivity(gitHubIntent)
        }

        text_twitter.setOnClickListener {
            val twitterIntent = Intent(Intent.ACTION_VIEW)
            try {
                packageManager.getPackageInfo("com.twitter.android", 0)
                twitterIntent.data = Uri.parse("twitter://user?screen_name=_ChibuFirst")
                twitterIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            } catch (e: Exception) {
                twitterIntent.data = Uri.parse("https://twitter.com/_ChibuFirst")
            }
            startActivity(twitterIntent)
        }

        text_facebook.setOnClickListener {
            val facebookIntent = Intent(Intent.ACTION_VIEW)
            try {
                packageManager.getPackageInfo("com.facebook.katana", 0)
                facebookIntent.data = Uri.parse("fb://profile/Onuoha.Godfirst")
            } catch (e: Exception) {
                facebookIntent.data = Uri.parse("https://facebook.com/Onuoha.Godfirst")
            }
            startActivity(facebookIntent)
        }

        text_linkedin.setOnClickListener {
            val linkedInIntent = Intent(Intent.ACTION_VIEW)
            try {
                packageManager.getPackageInfo("com.linkedin.android", 0)
                linkedInIntent.data = Uri.parse("linkedin://chibufirst")
            } catch (e: Exception) {
                linkedInIntent.data = Uri.parse("https://www.linkedin.com/in/chibufirst")
            }
            startActivity(linkedInIntent)
        }

        text_instagram.setOnClickListener {
            val instagramIntent = Intent(Intent.ACTION_VIEW)
            try {
                packageManager.getPackageInfo("com.instagram.android", 0)
                instagramIntent.data = Uri.parse("https://instagram.com/_u/_chibufirst")
            } catch (e: Exception) {
                instagramIntent.data = Uri.parse("https://instagram.com/_chibufirst")
            }
            startActivity(instagramIntent)
        }

        text_whatsapp.setOnClickListener {
            val whatsAppIntent = Intent(Intent.ACTION_VIEW)
            try {
                packageManager.getPackageInfo("com.whatsapp", 0)
                whatsAppIntent.data = Uri.parse("https://api.whatsapp.com/send?phone=+234 9091706766")
            } catch (e: Exception) {
                whatsAppIntent.data = Uri.parse("https://api.whatsapp.com/send?phone=+234 9091706766")
            }
            startActivity(whatsAppIntent)
        }

        text_medium.setOnClickListener{
            val mediumIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://medium.com/@chibufirst"))
            startActivity(mediumIntent)
        }

        text_bitbucket.setOnClickListener {
            val bitbucketIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://bitbucket.org/%7Ba02072a5-05a7-44ad-9907-1d21b91eba04%7D/"))
            startActivity(bitbucketIntent)
        }

        text_stackoverflow.setOnClickListener {
            val stackOverflowIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://stackoverflow.com/users/11741093/chibufirst"))
            startActivity(stackOverflowIntent)
        }

        text_website.setOnClickListener {
            val websiteIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://chibufirst.imfast.io"))
            startActivity(websiteIntent)
        }

        text_contact.setOnClickListener {
            val contactIntent = Intent(Intent.ACTION_DIAL)
            val contactUri = Uri.parse("tel:+2349091706766")
            contactIntent.data = contactUri
            startActivity(contactIntent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "The Activity is onStart state")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "The Activity is onResume state")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "The Activity is onRestart state")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "The Activity is onPause state")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "The Activity is onDestroy state")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "The Activity is onStop state")
    }
}
