package org.rajalakshmi.exp1



import android.graphics.Color

import android.support.v7.app.AppCompatActivity

import android.os.Bundle

import android.widget.Button

import android.widget.LinearLayout

import android.widget.TextView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        val tvText: TextView = findViewById(R.id.tvText)

        val btFontSize: Button = findViewById(R.id.btFontSize)

        val btFontColor: Button = findViewById(R.id.btFontColor)

        val btBackgroundColor: Button = findViewById(R.id.btBackgroundColor)

        val linearLayout: LinearLayout = findViewById(R.id.linearlayout)



        var fontSize: Float = 5f

        var fontColor: Int = 0

        var backgroundColor: Int = 0



        btFontSize.setOnClickListener {

            tvText.setTextSize(fontSize)

            fontSize = (fontSize + 5) % 50

        }



        btFontColor.setOnClickListener {

            when (fontColor % 3) {

                0 -> tvText.setTextColor(Color.RED)

                1 -> tvText.setTextColor(Color.GREEN)

                2 -> tvText.setTextColor(Color.BLUE)

            }

            fontColor++

        }



        btBackgroundColor.setOnClickListener {

            when (backgroundColor % 3) {

                0 -> linearLayout.setBackgroundColor(Color.RED)

                1 -> linearLayout.setBackgroundColor(Color.GREEN)

                2 -> linearLayout.setBackgroundColor(Color.BLUE)

            }

            backgroundColor++

        }

    }

}
