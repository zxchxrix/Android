package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var yesCount: TextView
    private lateinit var noCount: TextView
    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        yesButton = findViewById(R.id.yes_button)
        noButton = findViewById(R.id.no_button)
        resetButton = findViewById(R.id.reset_button)


        yesButton.setOnClickListener {
            yesCount++
            updateCounts()
        }

        noButton.setOnClickListener {
            noCount++
            updateCounts()
        }

        resetButton.setOnClickListener {
            yesCount = 0
            noCount = 0
            updateCounts()
        }
    }

    private fun updateCounts() {
        yesCount = findViewById(R.id.yes_count_textview)
        noCount = findViewById(R.id.no_count_textview)

        yesCount.text = "Yes: $yesCount"
        noCount.text = "No: $noCount"
    }
}