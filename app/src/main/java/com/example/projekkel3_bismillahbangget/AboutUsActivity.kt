package com.example.projekkel3_bismillahbangget


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}