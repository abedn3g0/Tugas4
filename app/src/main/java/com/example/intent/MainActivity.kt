package com.example.intent

import android.app.AlarmManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    fun share(){
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, text1.text.toString())
        intent.type = "text/plain"
        startActivity(Intent(Intent.createChooser(intent,"Share to")))
    }

    fun telp() {
        val callIntent: Intent = Uri.parse("tel: " + text2.text).let { number ->
            Intent(Intent.ACTION_DIAL, number)
        }
        startActivity(callIntent)
    }

    fun web(){
        startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("http://" + text3.text)))
    }

    fun cam(){
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        startActivity(intent)
    }

    fun galeri(){
        startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("content://media/external/images/media/")))
    }

    fun alarm(){
        val intent = Intent("android.intent.action.SHOW_ALARMS")
        startActivity(intent)
    }
    fun peta(){
        startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=" + text4.text)))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text1 =findViewById<EditText>(R.id.text1)
        val text2 =findViewById<EditText>(R.id.text2)
        val text3 =findViewById<EditText>(R.id.text3)
        val text4 =findViewById<EditText>(R.id.text4)
        val btnshare =findViewById<Button>(R.id.btnshare)
        val btncall = findViewById<Button>(R.id.btncall)
        val btnweb = findViewById<Button>(R.id.btnweb)
        val btncam = findViewById<Button>(R.id.btncam)
        val btngaleri = findViewById<Button>(R.id.btngaleri)
        val btnalarm = findViewById<Button>(R.id.btnalarm)
        val btnmap = findViewById<Button>(R.id.btnmap)


        btnshare.setOnClickListener(){
            share()
        }
        btncall.setOnClickListener(){
            telp()
        }
        btnweb.setOnClickListener(){
            web()
        }
        btncam.setOnClickListener(){
            cam()
        }
        btngaleri.setOnClickListener(){
            galeri()
        }
        btnalarm.setOnClickListener(){
            alarm()
        }
        btnmap.setOnClickListener(){
            peta()
        }
    }
}