package com.hilton.calculate_bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startMain()
        }, 3000.toLong())
    }
    private fun startMain(){
        val registerIntent = Intent(this, BMIActivity::class.java)
        startActivity(registerIntent)
    }
}