package com.example.emaildemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etEmail : EditText = findViewById(R.id.etName)
        val etSubject : EditText = findViewById(R.id.etSubject)
        val etText : EditText = findViewById(R.id.etText)
        val btSend : Button = findViewById(R.id.btSend)

        btSend.setOnClickListener {
            val email= etEmail.text.toString()
            val subject = etSubject.text.toString()
            val text = etText.text.toString()
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, text)
            intent.type= "message/rfc822"
            startActivity(Intent.createChooser(intent,"Choose a Client...!"))
        }
    }
}
