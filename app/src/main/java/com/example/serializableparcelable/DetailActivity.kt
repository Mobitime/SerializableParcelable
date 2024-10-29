package com.example.serializableparcelable

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        findViewById<TextView>(R.id.textFirstName).text = intent.getStringExtra("firstName")
        findViewById<TextView>(R.id.textLastName).text = intent.getStringExtra("lastName")
        findViewById<TextView>(R.id.textAddress).text = intent.getStringExtra("address")
        findViewById<TextView>(R.id.textPhone).text = intent.getStringExtra("phone")
    }
}