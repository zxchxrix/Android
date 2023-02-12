package com.example.helloandroid2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.tapHereButton)
        button.setOnClickListener {
            Toast.makeText(this, "Hello Zac!", Toast.LENGTH_LONG).show()
        }
    }
}