package com.example.landscapelayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

const val EXTRA_SQUARE_SIZE = "com.example.landscapelayout.tap_the_square.SQUARE_SIZE"

class MainActivity : AppCompatActivity() {

    private lateinit var seekbar: SeekBar
    private lateinit var seekBarLabel: TextView
    private lateinit var showSquareButton: Button

    private val squareResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result -> handleSquareResult(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekbar = findViewById(R.id.seek_bar)
        seekBarLabel = findViewById(R.id.seek_bar_label)
        showSquareButton = findViewById(R.id.show_square_button)

        val initialProgress = seekbar.progress
        updateLabel(initialProgress)

        seekbar.setOnSeekBarChangeListener( object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbarComponent: SeekBar?, progress: Int, fromUser: Boolean) {
                updateLabel(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        showSquareButton.setOnClickListener() {
            showSquare()
        }
    }

    private fun updateLabel(progress: Int) {
        seekBarLabel.text = getString(R.string.seekbar_value_message, progress)
    }

    private fun showSquare() {
//        // launch the SquareActivity
//        val showSquareIntent = Intent(this, SquareActivity::class.java)
//        showSquareIntent.putExtra(EXTRA_SQUARE_SIZE, seekbar.progress)
//        // startActivity(showSquareIntent)
//        squareResultLauncher.launch(showSquareIntent)

        // Tell the SquareActivity how large the square should be
        // based on the progress of the Seekbar

        Intent(this, SquareActivity::class.java).apply {
            putExtra(EXTRA_SQUARE_SIZE, seekbar.progress)
            squareResultLauncher.launch(this)
        }
    }

    private fun handleSquareResult(result: ActivityResult) {
        if (result.resultCode == RESULT_OK) {
            val intent = result.data
            val tapped = intent?.getBooleanExtra(EXTRA_TAPPED_INSIDE_SQUARE, false) ?: false
            val message = if (tapped) {
                getString(R.string.got_the_square)
            } else {
                getString(R.string.did_not_get_the_square)
            }

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        } else if (result.resultCode == RESULT_CANCELED) {
            Toast.makeText(this, getString(R.string.no_tap), Toast.LENGTH_SHORT).show()
        }
    }

}