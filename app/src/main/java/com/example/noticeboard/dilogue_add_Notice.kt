package com.example.noticeboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DialogAddNotice : AppCompatActivity() {

    private lateinit var etNotice: EditText
    private lateinit var btnAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dilogue_add_notice)

        // Initialize UI elements
        etNotice = findViewById(R.id.etNotice)
        btnAdd = findViewById(R.id.btnAdd)

        // Debugging - Check if button is found
        if (btnAdd == null) {
            Log.e("DialogAddNotice", "Button btnAdd is NULL!")
        }

        // Set click listener for Add button
        btnAdd.setOnClickListener {
            Log.d("DialogAddNotice", "Add button clicked") // Debug log

            val noticeText = etNotice.text.toString().trim()

            if (noticeText.isNotEmpty()) {
                val resultIntent = Intent()
                resultIntent.putExtra("new_notice", noticeText)
                setResult(Activity.RESULT_OK, resultIntent)
                finish() // Close this activity and return to MainActivity
            } else {
                Toast.makeText(this, "Please enter a notice!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
