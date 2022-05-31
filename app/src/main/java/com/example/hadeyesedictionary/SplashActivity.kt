package com.example.hadeyesedictionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    val TIME_SCREEN:Long = 5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.myLooper()!!).postDelayed({
           val intent = Intent(this,MainActivity::class.java)
           startActivity(intent)
           overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
        },TIME_SCREEN)
    }
}