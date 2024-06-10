package com.example.practicumexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    private val maxTemperatures = intArrayOf(22, 25, 21, 26, 23, 24, 22)
    private val minTemperatures = intArrayOf(18, 19, 17, 20, 18, 19, 18)
    private val conditions =
        arrayOf("Sunny", "Cloudy", "Rainy", "Sunny", "Partly Cloudy", "Sunny", "Rainy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val details = StringBuilder("Weekly Weather Details:\n")
        for (i in maxTemperatures.indices) {
            details.append("Day ${i + 1}: Max Temp: ${maxTemperatures[i]}°C, Min Temp: ${minTemperatures[i]}°C, Condition: ${conditions[i]}\n")
        }
        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        detailsTextView.text = details.toString()

        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}