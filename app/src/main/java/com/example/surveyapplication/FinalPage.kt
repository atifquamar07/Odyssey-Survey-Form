package com.example.surveyapplication

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class FinalPage : AppCompatActivity() {

    private val output : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_page)

        val ratingsList = intent.getIntegerArrayListExtra("ratingsList")
        val isRatingProvided = intent.getIntegerArrayListExtra("isRatingProvided")

        if (isRatingProvided != null) {
            if(isRatingProvided[0] == 1){
                output.add("Rating for Music category: ${ratingsList?.get(0)} stars")
            }
            else {
                output.add("Rating for Music category: Not Provided")
            }
            if(isRatingProvided[1] == 1){
                output.add("Rating for Dance category: ${ratingsList?.get(1)} stars")
            }
            else {
                output.add("Rating for Dance category: Not Provided")
            }
            if(isRatingProvided[2] == 1){
                output.add("Rating for Play category: ${ratingsList?.get(2)} stars")
            }
            else {
                output.add("Rating for Play category: Not Provided")
            }
            if(isRatingProvided[3] == 1){
                output.add("Rating for Fashion category: ${ratingsList?.get(3)} stars")
            }
            else {
                output.add("Rating for Play category: Not Provided")
            }
            if(isRatingProvided[4] == 1){
                output.add("Rating for Food category: ${ratingsList?.get(4)} stars")
            }
            else {
                output.add("Rating for Food category: Not Provided")
            }
        }

        val arrayAdapter: ArrayAdapter<*>

        // access the listView from xml file
        val mListView = findViewById<ListView>(R.id.list)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, output)
        mListView.adapter = arrayAdapter

    }
}