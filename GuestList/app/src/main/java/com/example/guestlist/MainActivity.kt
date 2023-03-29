package com.example.guestlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

const val LAST_GUEST_NAME_KEY = "last-guest-name-bundle-key"
class MainActivity : AppCompatActivity() {

    private lateinit var addGuestButton: Button
    private lateinit var newGuestEditText: EditText
    private lateinit var guestList: TextView
    private lateinit var lastGuestAdded: TextView
    private lateinit var deleteButton: Button

    private val guestListViewModel: GuestListViewModel by lazy {
    // lazy initialization - lambda won't be called until guestListModel used
        ViewModelProvider(this).get(GuestListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addGuestButton = findViewById(R.id.add_guest_button)
        newGuestEditText = findViewById(R.id.new_guest_input)
        guestList = findViewById(R.id.list_of_guests)
        lastGuestAdded = findViewById(R.id.last_guest_added)
        deleteButton = findViewById(R.id.delete_guests_button)

        addGuestButton.setOnClickListener() {
            addNewGuest()
        }

        deleteButton.setOnClickListener() {
            clearGuestList()
            updateGuestList()
        }

        val savedLastGuestMessage = savedInstanceState?.getString(LAST_GUEST_NAME_KEY)
        lastGuestAdded.text = savedLastGuestMessage

        updateGuestList()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAST_GUEST_NAME_KEY, lastGuestAdded.text.toString())
    }

    private fun addNewGuest() {
        val newGuestName = newGuestEditText.text.toString()
        if (newGuestName.isNotBlank()) {
//            guestNames.add(newGuestName)
            guestListViewModel.addGuest(newGuestName)
            updateGuestList()
            newGuestEditText.text.clear()
            lastGuestAdded.text = getString(R.string.last_guest_message, newGuestName)
        }

    }

    private fun updateGuestList() {
//        val guestDisplay = guestNames.sorted().joinToString("\n")
        val guests = guestListViewModel.getSortedGuestNames()
        val guestDisplay = guests.joinToString("\n")
        guestList.text = guestDisplay
    }

    private fun clearGuestList() {
        guestListViewModel.clearGuestList()
        lastGuestAdded.text = ""
    }
}