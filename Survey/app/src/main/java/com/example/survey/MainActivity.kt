package com.example.survey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val questions = listOf("Do you like the weather in MN?",
                                    "Do you see yourself living here in the next 5 years?",
                                    "Would you recommend it for others looking to relocate?")

    private lateinit var questionView: TextView
    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var clearButton: Button
    private lateinit var yesCounter: TextView
    private lateinit var noCounter: TextView
    private lateinit var totalAskedView: TextView

    private var yeses = 0
    private var nos = 0
    private var currentIndex = 0
    private var totalAsked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Assign variables to Views
        yesButton = findViewById(R.id.yes_button)
        noButton = findViewById(R.id.no_button)
        clearButton = findViewById(R.id.clear_button)
        questionView = findViewById(R.id.question)
        totalAskedView = findViewById(R.id.total_asked)

        questionView.text = questions[currentIndex]
        totalAskedView.text = getString(R.string.total_asked_text, totalAsked)

        yesCounter = findViewById(R.id.yes_counter)
        noCounter = findViewById(R.id.no_counter)

        yesButton.setOnClickListener {
            yeses++
            yesCounter.text = getString(R.string.yes_count, yeses)
            nextQuestion()
            checkCompletedAllQuestions()
        }

        noButton.setOnClickListener {
            nos++
            noCounter.text = getString(R.string.no_count, nos)
            nextQuestion()
            checkCompletedAllQuestions()
        }

        clearButton.setOnClickListener {
            reset()
        }
    }

    private fun nextQuestion() {
        totalAsked = (totalAsked + 1) % (questions.size + 1)
        currentIndex = (currentIndex + 1) % questions.size
        questionView.text = questions[currentIndex]
        totalAskedView.text = getString(R.string.total_asked_text, totalAsked)
    }

    private fun reset() {
        yeses = 0
        nos = 0
        yesCounter.text = getString(R.string.start_yes_count)
        noCounter.text = getString(R.string.start_no_count)
        currentIndex = 0
        questionView.text = questions[currentIndex]
    }

    private fun checkCompletedAllQuestions() {
        if (totalAsked == questions.size) {
            Toast.makeText(this, "You've completed all questions", Toast.LENGTH_SHORT).show()
            reset()
        }
    }

}
