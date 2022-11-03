package com.example.exercicio_1

import android.graphics.Color
import android.graphics.ColorFilter
import android.icu.number.IntegerWidth
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorLong
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClickColor = findViewById<Button>(R.id.btnClickColor)
        val imgBackground = findViewById<ImageView>(R.id.imgBackground)
        val txtChangeTextRgb = findViewById<TextView>(R.id.txtRgb)
        val txtChangeTextHex = findViewById<TextView>(R.id.txtHex)

        btnClickColor.setOnClickListener {
            imgBackground.setBackgroundColor(randomColorRgb())
            txtChangeTextRgb.text = randomColorRgb().toString()
            txtChangeTextHex.text = randomColorHex()
        }
    }
    private fun randomColorRgb(): Int {
        val color = java.util.Random()
        val red = color.nextInt(256)
        val green = color.nextInt(256)
        val blue = color.nextInt(256)

        return Color.rgb(red, green, blue)
    }

    private fun randomColorHex(): String {
        val color = java.util.Random()
        val red = color.nextInt(256)
        val green = color.nextInt(256)
        val blue = color.nextInt(256)

        return String.format("#%02x%02x%02x", red, green, blue)
    }
}