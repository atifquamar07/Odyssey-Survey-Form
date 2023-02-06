package com.example.surveyapplication

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var roleInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInput = findViewById(R.id.name_input_box)
        roleInput = findViewById(R.id.roleinput)

        val eventPage: Button = findViewById(R.id.buttonForEventPage)

        var name = ""
        var role = ""

        nameInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                name = s.toString()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        roleInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                role = s.toString()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        eventPage.setOnClickListener(){

            if(name == "" && role == ""){
                Toast.makeText(applicationContext, "Name and Role field cannot be blank!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(name == ""){
                Toast.makeText(applicationContext, "Name field cannot be blank!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(role == ""){
                Toast.makeText(applicationContext, "Role field cannot be blank!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, EventsList::class.java)
            startActivity(intent)
        }
    }
}