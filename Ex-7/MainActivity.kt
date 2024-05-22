package org.rajalakshmi.exp7sdcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etRegisterNo:EditText=findViewById(R.id.etRegisterNo)
        val etName:EditText=findViewById(R.id.etName)
        val etCGPA:EditText=findViewById(R.id.etCgpa)
        val btSave:Button=findViewById(R.id.btSave)
        val btLoad:Button=findViewById(R.id.btLoad)

        btSave.setOnClickListener {
            val registerNo = etRegisterNo.text.toString()
            val name = etName.text.toString()
            val cgpa = etCGPA.text.toString()

            val file = File(getExternalFilesDir(null),"student.txt")
            val fos = FileOutputStream(file)
            fos.write("$registerNo, $name, $cgpa\n".toByteArray())
            etRegisterNo.text.clear()
            etName.text.clear()
            etCGPA.text.clear()
        }
        btLoad.setOnClickListener {
            val file = File(getExternalFilesDir(null),"student.txt")
            val fis = FileInputStream(file)
            val isr = InputStreamReader(fis)
            val br = BufferedReader(isr)
            val line : String
            line = br.readLine()
            var parts = line.split(",")
            etRegisterNo.setText(parts[0])
            etName.setText(parts[1])
            etCGPA.setText(parts[2])
            fis.close()

        }

    }
}
