package com.example.sagefarkle

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sagefarkle.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var rollButton: Button
    private lateinit var scoreButton: Button
    private lateinit var resetButton: Button
    private lateinit var scoreTextView: TextView
    private lateinit var rollTextView: TextView
    private var currentScore: Int = 0
    private var currentRoll: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the UI elements
        rollButton = findViewById(R.id.rollButton)
        scoreButton = findViewById(R.id.scoreButton)
        resetButton = findViewById(R.id.resetButton)
        scoreTextView = findViewById(R.id.scoreTextView)
        rollTextView = findViewById(R.id.rollTextView)

        // Attach click listeners to the buttons
        rollButton.setOnClickListener { rollDice() }
        scoreButton.setOnClickListener { addScore() }
        resetButton.setOnClickListener { resetGame() }
    }

    // Roll the dice and update the UI
    private fun rollDice() {
        val dice1 = Random.nextInt(1, 7)
        val dice2 = Random.nextInt(1, 7)

        // Check for Farkle
        if (dice1 == 1 || dice2 == 1 || (dice1 == 5 && dice2 == 5)) {
            currentScore = 0
            currentRoll = 0
            scoreTextView.text = "Score: $currentScore"
            rollTextView.text = "Roll: $currentRoll (Farkle!)"
        } else {
            currentRoll++
            if (dice1 == 5) {
                currentScore += 50
            }
            if (dice2 == 5) {
                currentScore += 50
            }
            if (dice1 == dice2) {
                currentScore += dice1 * 100
            }
            scoreTextView.text = "Score: $currentScore"
            rollTextView.text = "Roll: $currentRoll (Dice 1: $dice1, Dice 2: $dice2)"
        }
    }

    // Add the current score to the total score and reset the current score and roll
    private fun addScore() {
        scoreTextView.text = "Score: ${currentScore + scoreTextView.text.toString().substringAfter(":").toInt()}"
        currentScore = 0
        currentRoll = 0
        rollTextView.text = "Roll: $currentRoll"
    }

    // Reset the game
    private fun resetGame() {
        currentScore = 0
        currentRoll = 0
        scoreTextView.text = "Score: 0"
        rollTextView.text = "Roll: 0"
    }
}