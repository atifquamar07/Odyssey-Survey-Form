package com.example.surveyapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInput = findViewById(R.id.name_input_box)

        val eventPage: Button = findViewById(R.id.buttonForEventPage)

        eventPage.setOnClickListener(){
            val intent = Intent(this, EventsList::class.java)
            startActivity(intent)
        }

    }
}