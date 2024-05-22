package org.rajalakshmi.exp10telephonyservice

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etnon : EditText = findViewById(R.id.etnoa)
        val etpt : EditText = findViewById(R.id.etphonetype)
        val etnciso : EditText = findViewById(R.id.etniso)
        val etsimciso : EditText = findViewById(R.id.etsimiso)
        val etdsv : EditText = findViewById(R.id.etsoftwareversion)
        val btgetdetails : Button = findViewById(R.id.btget)
        //6.0 & above(api23)
        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_PHONE_STATE)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_PHONE_STATE),1000)
        }
        val telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
        btgetdetails.setOnClickListener {
            val non = telephonyManager.networkOperatorName
            val simciso = telephonyManager.simCountryIso
            val nciso = telephonyManager.networkCountryIso
            val dsv = telephonyManager.deviceSoftwareVersion
            val pt = telephonyManager.phoneType

            etnon.setText(non)
            etsimciso.setText(simciso)
            etnciso.setText(nciso)
            etdsv.setText(dsv)
            var strPT : String = ""
            when(pt){
                TelephonyManager.PHONE_TYPE_GSM -> strPT = "GSM"
                TelephonyManager.PHONE_TYPE_CDMA -> strPT = "CDMA"
                TelephonyManager.PHONE_TYPE_NONE -> strPT = "NONE"
            }
            etpt.setText(strPT)


        }
    }
}
