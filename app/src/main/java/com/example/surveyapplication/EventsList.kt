package com.example.surveyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RatingBar
import android.widget.Toast

class EventsList : AppCompatActivity() {

    private lateinit var music: CheckBox
    private lateinit var dance: CheckBox
    private lateinit var play: CheckBox
    private lateinit var fashion: CheckBox
    private lateinit var food: CheckBox
    private lateinit var submit: Button
    private lateinit var clear: Button
    private lateinit var ratingMusic: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events_list)

        music = findViewById(R.id.music)
        dance = findViewById(R.id.dance)
        play = findViewById(R.id.play)
        fashion = findViewById(R.id.fashion)
        food = findViewById(R.id.food)
        submit = findViewById(R.id.submitButton)
        clear = findViewById(R.id.clearButton)

        clear.setOnClickListener{
            if(music.isChecked){
                music.isChecked = false
            }
            if(dance.isChecked){
                dance.isChecked = false
            }
            if(play.isChecked){
                play.isChecked = false
            }
            if(fashion.isChecked){
                fashion.isChecked = false
            }
            if(food.isChecked){
                food.isChecked = false
            }
        }
    }
}