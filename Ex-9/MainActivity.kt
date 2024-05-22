package org.rec.exp8alertbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etMessage : EditText = findViewById(R.id.etmsg)
        val btDisplay : Button = findViewById(R.id.btdisplay)
        btDisplay.setOnClickListener { 
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("MAD LAB")
                .setMessage(etMessage.text.toString())
                .setPositiveButton("ok"){
                    dialog, which -> 
                    Toast.makeText(applicationContext,"you clicked ok",Toast.LENGTH_LONG)
                }
                .setNegativeButton("Cancel"){
                    dialog,which ->
                    Toast.makeText(applicationContext,"You clicked cancel",Toast.LENGTH_LONG)
                }
                .create()
                alertDialog.show()
        }
    }
}
