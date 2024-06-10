package com.example.practicumexam

import android.content.Intent
import android.credentials.ClearCredentialStateException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private val temperatures = intArrayOf(20, 22, 19, 24, 21, 23, 20)
private val conditions = arrayOf("Sunny", "Cloudy", "Rainy", "Sunny", "Partly Cloudy", "Sunny", "Rainy")

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val refreshButton = findViewById<Button>(R.id.refreshButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val detailsButton = findViewById<Button>(R.id.detailsButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        refreshButton.setOnClickListener { refreshWeather() }
        clearButton.setOnClickListener { clearData() }
        detailsButton.setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))
        }
        exitButton.setOnClickListener { finish() }
    }

    private fun refreshWeather() {
        val tempEditText = findViewById<TextView>(R.id.refreshButton)
        val conditionEditText = findViewById<TextView>(R.id.conditionEditText)
        val tempInput = tempEditText.text.toString()
        val conditionInput = conditionEditText.text.toString()

        if (tempInput.isNotEmpty() && conditionInput.isNotEmpty()) {
            val temp = tempInput.toIntOrNull()
            if (temp != null) {
                temperatures[0] = temp
                conditions[0] = conditionInput
                updateWeatherText()
            } else {
                Toast.makeText(this, "Please enter valid positive numbers for all fields.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearData() {
        val weatherTextView = findViewById<TextView>(R.id.clearButton)
        val tempEditText = findViewById<TextView>(R.id.weatherTextView)
        val conditionEditText = findViewById<TextView>(R.id.conditionEditText)
        weatherTextView.text = "Data Cleared"
        tempEditText.text.clear()
        conditionEditText.text.clear()
    }

    private fun updateWeatherText() {
        val avgTemp = temperatures.average()
        val weatherTextView = findViewById<TextView>(R.id.weatherTextView)
        weatherTextView.text = "Current Weather: ${temperatures[0]}°C, ${conditions[0]}\nAverage Temp: $avgTemp°C"
    }
}

private fun Any.clear() {
    TODO("Not yet implemented")
}


