package com.example.surveyapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var roleInput: EditText

    override fun onStart() {
        super.onStart()
        Log.i("Main-Activity","Activity started!")
        Toast.makeText(applicationContext, "MainActivity started!", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Log.i("Main-Activity","Activity Resumed!")
        Toast.makeText(applicationContext, "MainActivity Resumed!", Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Log.i("Main-Activity","Activity Paused!")
        Toast.makeText(applicationContext, "MainActivity Paused!", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("Main-Activity","Activity Stopped!")
        Toast.makeText(applicationContext, "MainActivity Stopped!", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Main-Activity","Activity Restarted!")
        Toast.makeText(applicationContext, "MainActivity Restarted!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Main-Activity","Activity Destroyed!")
        Toast.makeText(applicationContext, "MainActivity Destroyed!", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Main-Activity","Activity Created!")
        Toast.makeText(applicationContext, "MainActivity Created!", Toast.LENGTH_SHORT).show()

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
            Toast.makeText(applicationContext, "Name and Role recorded!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, EventsList::class.java)
            startActivity(intent)
        }
    }
}