package com.example.exercicio_1

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.ColorSpace
import android.icu.number.IntegerWidth
import android.os.Build
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorLong
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.alpha
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClickColor = findViewById<Button>(R.id.btnClickColor)
        val imgBackground = findViewById<ImageView>(R.id.imgBackground)
        val txtChangeTextRgb = findViewById<TextView>(R.id.txtRgb)
        val txtChangeTextHex = findViewById<TextView>(R.id.txtHex)

        btnClickColor.setOnClickListener {
            val colorChange = randomColorAll()
            imgBackground.setBackgroundColor(colorChange)
            txtChangeTextRgb.text =  String.format("R: %d, G: %d, B: %d, A: %d", colorChange.red, colorChange.green, colorChange.blue, colorChange.alpha)
            txtChangeTextHex.text = String.format("HEXADECIMAL: #%02X%02X%02X", colorChange.red, colorChange.green, colorChange.blue)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun randomColorAll(): Int{
        val color = java.util.Random()
        val alpha = Color.alpha(color.nextLong())
        val red = color.nextInt(256)
        val green = color.nextInt(256)
        val blue = color.nextInt(256)

        return Color.argb(alpha.toFloat(), red.toFloat(), green.toFloat(), blue.toFloat())
    }
}
