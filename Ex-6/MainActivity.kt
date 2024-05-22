package org.rec.formvalidationexp6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etUserName : EditText = findViewById(R.id.etUserName)
        val etPinNo : EditText = findViewById(R.id.etPinNo)
        val btLogin : Button = findViewById(R.id.btLogin)
        val brclear : Button = findViewById(R.id.btClear)

        //username-alphabets -> one or more
        //pinno
        btLogin.setOnClickListener {
            val checkUserName = "[a-zA-z]+".toRegex()
            val checkPinNo = "[0-9]{4}".toRegex()
            if (checkUserName.matches(etUserName.text.toString()) &&
                    checkPinNo.matches(etPinNo.text.toString()))
            {
                val intent = Intent(this,MainActivity2::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(applicationContext, "Invalid User Name", Toast.LENGTH_SHORT).show()

            }

        }
    }
}
