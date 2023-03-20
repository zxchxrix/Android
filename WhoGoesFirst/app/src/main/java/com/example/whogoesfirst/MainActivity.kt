package com.example.whogoesfirst

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whogoesfirst.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var team1Input: EditText
    private lateinit var team2Input: EditText
    private lateinit var resultText: TextView
    private lateinit var randomButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creating the UI elements
        randomButton = findViewById(R.id.randomButton)
        team1Input = findViewById(R.id.team1Input)
        team2Input = findViewById(R.id.team2Input)
        resultText = findViewById(R.id.resultText)

        randomButton.setOnClickListener {
            onRandomButtonClick()
        }

    }

    private fun onRandomButtonClick() {
        // Get the team names from the EditText widgets
        val team1 = team1Input.text.toString()
        val team2 = team2Input.text.toString()

        if (team1.isBlank() || team2.isBlank()) {
            Toast.makeText(this, "Please enter two team names", Toast.LENGTH_SHORT).show()
        } else {
            // Generate a random number (0 or 1) to select a team
            val randomNumber = Random.nextInt(2)

            // Set the result text to the selected team name
            val result = if (randomNumber == 0) team1 else team2
            resultText.text = "$result gets first ball"
        }

    }
}
