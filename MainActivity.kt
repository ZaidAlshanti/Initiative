package com.app1.one;

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signupText = findViewById<TextView>(R.id.signupText)
        val loginBtn = findViewById<Button>(R.id.login_btn)

        signupText.setOnClickListener {
            val intent = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(intent)
        }


        loginBtn.setOnClickListener {

        }
    }
}
