package com.example.surveyapplication

import android.content.Intent
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

    // Hashmap to store ratings
    private var ratingsMap : HashMap<String, Float> = HashMap<String, Float> ()

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
        ratingsMap["Music"] = -1.0f
        ratingsMap["Dance"] = -1.0f
        ratingsMap["Play"] = -1.0f
        ratingsMap["Fashion"] = -1.0f
        ratingsMap["Food"] = -1.0f

        // Storing ratings in hashmap
        ratingMusic.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsMap["Music"] = rating
            Toast.makeText(applicationContext, "Rating for Music given: $rating star", Toast.LENGTH_SHORT).show()
        }
        ratingDance.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsMap["Dance"] = rating
            Toast.makeText(applicationContext, "Rating for Dance given: $rating star", Toast.LENGTH_SHORT).show()
        }
        ratingPlay.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsMap["Play"] = rating
            Toast.makeText(applicationContext, "Rating for Play given: $rating star", Toast.LENGTH_SHORT).show()
        }
        ratingFashion.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsMap["Fashion"] = rating
            Toast.makeText(applicationContext, "Rating for Fashion given: $rating star", Toast.LENGTH_SHORT).show()
        }
        ratingFood.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsMap["Food"] = rating
            Toast.makeText(applicationContext, "Rating for Food given: $rating star", Toast.LENGTH_SHORT).show()
        }

        // changing visibility of rating bar
        music.setOnClickListener{
            if(music.isChecked){
                ratingMusic.visibility = View.VISIBLE
            }
            else {
                ratingMusic.visibility = View.GONE
            }
        }
        dance.setOnClickListener{
            if(dance.isChecked){
                ratingDance.visibility = View.VISIBLE
            }
            else{
                ratingDance.visibility = View.GONE
            }
        }
        play.setOnClickListener{
            if(play.isChecked){
                ratingPlay.visibility = View.VISIBLE
            }
            else{
                ratingPlay.visibility = View.GONE
            }
        }
        fashion.setOnClickListener{
            if(fashion.isChecked){
                ratingFashion.visibility = View.VISIBLE
            }
            else{
                ratingFashion.visibility = View.GONE
            }
        }
        food.setOnClickListener{
            if(food.isChecked){
                ratingFood.visibility = View.VISIBLE
            }
            else{
                ratingFood.visibility = View.GONE
            }
        }

        // CLEAR button functionality
        clear.setOnClickListener{
            if(music.isChecked){
                music.isChecked = false
                ratingMusic.visibility = View.GONE
            }
            if(dance.isChecked){
                dance.isChecked = false
                ratingDance.visibility = View.GONE
            }
            if(play.isChecked){
                play.isChecked = false
                ratingPlay.visibility = View.GONE
            }
            if(fashion.isChecked){
                fashion.isChecked = false
                ratingFashion.visibility = View.GONE
            }
            if(food.isChecked){
                food.isChecked = false
                ratingFood.visibility = View.GONE
            }
            Toast.makeText(applicationContext, "Response cleared!", Toast.LENGTH_SHORT).show()
        }

        // SUBMIT button functionality
        submit.setOnClickListener(){
            val intent = Intent(this, FinalPage::class.java)
            Toast.makeText(applicationContext, "Response submitted!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }
}