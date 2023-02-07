package com.example.surveyapplication

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RatingBar
import android.widget.Toast

class EventsList : AppCompatActivity() {

    // Declaring variables
    private lateinit var music: CheckBox
    private lateinit var dance: CheckBox
    private lateinit var play: CheckBox
    private lateinit var fashion: CheckBox
    private lateinit var food: CheckBox
    private lateinit var submit: Button
    private lateinit var clear: Button
    private lateinit var ratingMusic: RatingBar
    private lateinit var ratingDance: RatingBar
    private lateinit var ratingPlay: RatingBar
    private lateinit var ratingFashion: RatingBar
    private lateinit var ratingFood: RatingBar

    private val ratingsList : ArrayList<Int> = ArrayList()
    private val isEventAttended : ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events_list)

        // Initializing variables
        music = findViewById(R.id.music)
        dance = findViewById(R.id.dance)
        play = findViewById(R.id.play)
        fashion = findViewById(R.id.fashion)
        food = findViewById(R.id.food)
        submit = findViewById(R.id.submitButton)
        clear = findViewById(R.id.clearButton)
        ratingMusic = findViewById(R.id.ratingBarMusic)
        ratingDance = findViewById(R.id.ratingBarDance)
        ratingPlay = findViewById(R.id.ratingBarPlay)
        ratingFashion = findViewById(R.id.ratingBarFashion)
        ratingFood = findViewById(R.id.ratingBarFood)

        // Ratings initialized to -1
        for(i in 1..5){
            ratingsList.add(0)
        }

        // Boolean for rating provided initialized to 0
        for(i in 1..5){
            isEventAttended.add(0)
        }

        // Storing ratings in hashmap
        ratingMusic.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsList[0] = rating.toInt()
            isEventAttended[0] = 1
        }
        ratingDance.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsList[1] = rating.toInt()
            isEventAttended[1] = 1
        }
        ratingPlay.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsList[2] = rating.toInt()
            isEventAttended[2] = 1
        }
        ratingFashion.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsList[3] = rating.toInt()
            isEventAttended[3] = 1
        }
        ratingFood.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsList[4] = rating.toInt()
            isEventAttended[4] = 1
        }

        // changing visibility of rating bar
        music.setOnClickListener{
            if(music.isChecked){
                ratingMusic.visibility = View.VISIBLE
                isEventAttended[0] = 1
            }
            else {
                ratingMusic.visibility = View.GONE
                ratingMusic.rating = 0.0f
                ratingsList[0] = 0
                isEventAttended[0] = 0
            }
        }
        dance.setOnClickListener{
            if(dance.isChecked){
                ratingDance.visibility = View.VISIBLE
                isEventAttended[1] = 1
            }
            else{
                ratingDance.visibility = View.GONE
                ratingsList[1] = 0
                ratingDance.rating = 0.0f
                isEventAttended[1] = 0
            }
        }
        play.setOnClickListener{
            if(play.isChecked){
                ratingPlay.visibility = View.VISIBLE
                isEventAttended[2] = 1
            }
            else {
                ratingPlay.visibility = View.GONE
                ratingsList[2] = 0
                ratingPlay.rating = 0.0f
                isEventAttended[2] = 0
            }
        }
        fashion.setOnClickListener{
            if(fashion.isChecked){
                ratingFashion.visibility = View.VISIBLE
                isEventAttended[3] = 1
            }
            else{
                ratingFashion.visibility = View.GONE
                ratingsList[3] = 0
                ratingFashion.rating = 0.0f
                isEventAttended[3] = 0
            }
        }
        food.setOnClickListener{
            if(food.isChecked){
                ratingFood.visibility = View.VISIBLE
                isEventAttended[4] = 1
            }
            else{
                ratingFood.visibility = View.GONE
                ratingsList[4] = 0
                ratingFood.rating = 0.0f
                isEventAttended[4] = 0
            }
        }

        // CLEAR button functionality
        clear.setOnClickListener{
            if(music.isChecked){
                music.isChecked = false
                ratingMusic.visibility = View.GONE
            }
            isEventAttended[0] = 0
            ratingMusic.rating = 0.0f
            ratingsList[0] = 0

            if(dance.isChecked){
                dance.isChecked = false
                ratingDance.visibility = View.GONE
            }
            ratingDance.rating = 0.0f
            ratingsList[1] = 0
            isEventAttended[1] = 0

            if(play.isChecked){
                play.isChecked = false
                ratingPlay.visibility = View.GONE
            }
            ratingPlay.rating = 0.0f
            ratingsList[2] = 0
            isEventAttended[2] = 0

            if(fashion.isChecked){
                fashion.isChecked = false
                ratingFashion.visibility = View.GONE
            }
            ratingFashion.rating = 0.0f
            ratingsList[3] = 0
            isEventAttended[3] = 0

            if(food.isChecked){
                food.isChecked = false
                ratingFood.visibility = View.GONE
            }
            ratingFood.rating = 0.0f
            ratingsList[4] = 0
            isEventAttended[4] = 0

            Toast.makeText(applicationContext, "Response cleared!", Toast.LENGTH_SHORT).show()
        }

        // SUBMIT button functionality
        submit.setOnClickListener(){
            val bundle = Bundle()
            ratingsList[0] = ratingMusic.rating.toInt()
            ratingsList[1] = ratingDance.rating.toInt()
            ratingsList[2] = ratingPlay.rating.toInt()
            ratingsList[3] = ratingFashion.rating.toInt()
            ratingsList[4] = ratingFood.rating.toInt()
            Toast.makeText(applicationContext, "Response submitted!", Toast.LENGTH_SHORT).show()
            bundle.putIntegerArrayList("ratingsList", ratingsList)
            bundle.putIntegerArrayList("isRatingProvided", isEventAttended)
            val intent = Intent(this, FinalPage::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }
}