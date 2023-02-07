package com.example.surveyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class FinalPage : AppCompatActivity() {

    private val output : ArrayList<String> = ArrayList()
    override fun onStart() {
        super.onStart()
        Log.i("FinalPage-Activity","Activity started!")
        Toast.makeText(applicationContext, "FinalPageActivity started!", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        Log.i("FinalPage-Activity","Activity Resumed!")
        Toast.makeText(applicationContext, "FinalPageActivity Resumed!", Toast.LENGTH_SHORT).show()
    }
    override fun onPause() {
        super.onPause()
        Log.i("FinalPage-Activity","Activity Paused!")
        Toast.makeText(applicationContext, "FinalPageActivity Paused!", Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Log.i("FinalPage-Activity","Activity Stopped!")
        Toast.makeText(applicationContext, "FinalPageActivity Stopped!", Toast.LENGTH_SHORT).show()
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("FinalPage-Activity","Activity Restarted!")
        Toast.makeText(applicationContext, "FinalPageActivity Restarted!", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("FinalPage-Activity","Activity Destroyed!")
        Toast.makeText(applicationContext, "FinalPageActivity Destroyed!", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("FinalPage-Activity","Activity Created!")
        Toast.makeText(applicationContext, "FinalPageActivity Created!", Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_final_page)

        val ratingsList = intent.getIntegerArrayListExtra("ratingsList")
        val isEventAttended = intent.getIntegerArrayListExtra("isRatingProvided")

        if (isEventAttended != null && ratingsList != null) {
            if(isEventAttended[0] == 1 && ratingsList[0] != 0){
                output.add("Music: Event attended and rated with ${ratingsList[0]} stars")
            }
            else if(isEventAttended[0] == 1 && ratingsList[0] == 0) {
                output.add("Music: Event attended and rated not provided")
            }
            else {
                output.add("Music: Event not attended")
            }

            if(isEventAttended[1] == 1 && ratingsList[1] != 0){
                output.add("Dance: Event attended and rated with ${ratingsList[1]} stars")
            }
            else if(isEventAttended[1] == 1 && ratingsList[1] == 0) {
                output.add("Dance: Event attended and rating not provided")
            }
            else {
                output.add("Dance: Event not attended")
            }

            if(isEventAttended[2] == 1 && ratingsList[2] != 0){
                output.add("Play: Event attended and rated with ${ratingsList[2]} stars")
            }
            else if(isEventAttended[2] == 1 && ratingsList[2] == 0) {
                output.add("Play: Event attended and rating not provided")
            }
            else {
                output.add("Play: Event not attended")
            }

            if(isEventAttended[3] == 1 && ratingsList[3] != 0){
                output.add("Fashion: Event attended and rated with ${ratingsList[3]} stars")
            }
            else if(isEventAttended[3] == 1 && ratingsList[3] == 0) {
                output.add("Fashion: Event attended and rating not provided")
            }
            else {
                output.add("Fashion: Event not attended")
            }

            if(isEventAttended[4] == 1 && ratingsList[4] != 0){
                output.add("Food: Event attended and rated with ${ratingsList[4]} stars")
            }
            else if(isEventAttended[0] == 1 && ratingsList[0] == 0) {
                output.add("Food: Event attended and rating not provided")
            }
            else {
                output.add("Food: Event not attended")
            }

        }

        val arrayAdapter: ArrayAdapter<*>

        // access the listView from xml file
        val mListView = findViewById<ListView>(R.id.list)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, output)
        mListView.adapter = arrayAdapter

    }
}