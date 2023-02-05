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

    private val ratingsList : ArrayList<Int> = ArrayList()
    private val isRatingProvided : ArrayList<Int> = ArrayList()

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
            ratingsList.add(-1)
        }

        // Boolean for rating provided initialized to 0
        for(i in 1..5){
            isRatingProvided.add(0)
        }

        // Storing ratings in hashmap
        ratingMusic.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsList[0] = rating.toInt()
            isRatingProvided[0] = 1
            Toast.makeText(applicationContext, "Rating for Music given: $rating star", Toast.LENGTH_SHORT).show()
        }
        ratingDance.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsList[1] = rating.toInt()
            isRatingProvided[1] = 1
            Toast.makeText(applicationContext, "Rating for Dance given: $rating star", Toast.LENGTH_SHORT).show()
        }
        ratingPlay.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsList[2] = rating.toInt()
            isRatingProvided[2] = 1
            Toast.makeText(applicationContext, "Rating for Play given: $rating star", Toast.LENGTH_SHORT).show()
        }
        ratingFashion.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsList[3] = rating.toInt()
            isRatingProvided[3] = 1
            Toast.makeText(applicationContext, "Rating for Fashion given: $rating star", Toast.LENGTH_SHORT).show()
        }
        ratingFood.setOnRatingBarChangeListener { _, rating, _ ->
            ratingsList[4] = rating.toInt()
            isRatingProvided[4] = 1
            Toast.makeText(applicationContext, "Rating for Food given: $rating star", Toast.LENGTH_SHORT).show()
        }

        // changing visibility of rating bar
        music.setOnClickListener{
            if(music.isChecked){
                ratingMusic.visibility = View.VISIBLE
                if(ratingsList[0] != -1){
                    isRatingProvided[0] = 1
                }
            }
            else {
                ratingMusic.visibility = View.GONE
                ratingMusic.rating = 0.0f
                isRatingProvided[0] = 0
            }
        }
        dance.setOnClickListener{
            if(dance.isChecked){
                ratingDance.visibility = View.VISIBLE
                if(ratingsList[1] != -1){
                    isRatingProvided[1] = 1
                }
            }
            else{
                ratingDance.visibility = View.GONE
                ratingDance.rating = 0.0f
                isRatingProvided[1] = 0
            }
        }
        play.setOnClickListener{
            if(play.isChecked){
                ratingPlay.visibility = View.VISIBLE
                if(ratingsList[2] != -1){
                    isRatingProvided[2] = 1
                }
            }
            else{
                ratingPlay.visibility = View.GONE
                ratingPlay.rating = 0.0f
                isRatingProvided[2] = 0
            }
        }
        fashion.setOnClickListener{
            if(fashion.isChecked){
                ratingFashion.visibility = View.VISIBLE
                if(ratingsList[3] != -1){
                    isRatingProvided[3] = 1
                }
            }
            else{
                ratingFashion.visibility = View.GONE
                ratingFashion.rating = 0.0f
                isRatingProvided[3] = 0
            }
        }
        food.setOnClickListener{
            if(food.isChecked){
                ratingFood.visibility = View.VISIBLE
                if(ratingsList[4] != -1){
                    isRatingProvided[4] = 1
                }
            }
            else{
                ratingFood.visibility = View.GONE
                ratingFood.rating = 0.0f
                isRatingProvided[4] = 0
            }
        }

        // CLEAR button functionality
        clear.setOnClickListener{
            if(music.isChecked){
                music.isChecked = false
                isRatingProvided[0] = 0
                ratingMusic.rating = 0.0f
                ratingMusic.visibility = View.GONE
            }
            if(dance.isChecked){
                dance.isChecked = false
                isRatingProvided[1] = 0
                ratingDance.rating = 0.0f
                ratingDance.visibility = View.GONE
            }
            if(play.isChecked){
                play.isChecked = false
                isRatingProvided[2] = 0
                ratingPlay.rating = 0.0f
                ratingPlay.visibility = View.GONE
            }
            if(fashion.isChecked){
                fashion.isChecked = false
                isRatingProvided[3] = 0
                ratingFashion.rating = 0.0f
                ratingFashion.visibility = View.GONE
            }
            if(food.isChecked){
                food.isChecked = false
                isRatingProvided[4] = 0
                ratingFood.rating = 0.0f
                ratingFood.visibility = View.GONE
            }
            Toast.makeText(applicationContext, "Response cleared!", Toast.LENGTH_SHORT).show()
        }

        // SUBMIT button functionality
        submit.setOnClickListener(){
            val bundle = Bundle()
            Toast.makeText(applicationContext, "Response submitted!", Toast.LENGTH_SHORT).show()
            bundle.putIntegerArrayList("ratingsList", ratingsList)
            bundle.putIntegerArrayList("isRatingProvided", isRatingProvided)
            val intent = Intent(this, FinalPage::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }
}