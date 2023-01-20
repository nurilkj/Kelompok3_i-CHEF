package com.example.projekkel3_bismillahbangget


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class ArabicCookingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arabic_cooking)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        //now get data from putExtra intent
        var intent = intent
        val aTitle = intent.getStringExtra("iTitle")
        val aDesc = intent.getStringExtra("iDesc")
        val aImageView = intent.getIntExtra("iImageView", 0)
        val aBahan = intent.getStringExtra("iBahan")
        val aLangkah = intent.getStringExtra("iLangkah")
        val arabicDesc: TextView = findViewById(R.id.arabicDeskripsi)
        val bahanText: TextView = findViewById(R.id.isiBahan)
        val langkahText: TextView = findViewById(R.id.isiCaraMasak)


        //set title in another activity
        actionBar.setTitle(aTitle)
        findViewById<ImageView>(R.id.arabicFoto).setImageResource(aImageView)
        arabicDesc.text = aDesc
        bahanText.text = aBahan
        langkahText.text = aLangkah
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}