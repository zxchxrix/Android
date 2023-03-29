package com.example.survey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var yesCount = 0
    private var noCount = 0

    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var resultText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the yes and no buttons
        yesButton = findViewById(R.id.yes_button)
        noButton = findViewById(R.id.no_button)

        // Set the click listeners for the buttons
        yesButton.setOnClickListener {
            yesCount++
            updateResult()
        }
        noButton.setOnClickListener {
            noCount++
            updateResult()
        }

        // Find the result text view
        val resultTextView = findViewById<TextView>(R.id.result_text_view)

        // Set the initial result
        resultTextView.text = getString(R.string.result_format, yesCount, noCount)

        // Find the clear button
        val clearButton = findViewById<Button>(R.id.clear_button)

        // Set the click listener for the clear button
        clearButton.setOnClickListener {
            yesCount = 0
            noCount = 0
            updateResult()
        }
    }

    private fun updateResult() {
        // Find the result text view
        val resultTextView = findViewById<TextView>(R.id.result_text_view)

        // Update the result
        resultTextView.text = getString(R.string.result_format, yesCount, noCount)
    }
}
