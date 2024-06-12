package com.example.fatisdaprofilemobile.ui.prodi

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fatisdaprofilemobile.R

class DetailProdi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_prodi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.prodi_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val prodi = intent.getParcelableExtra<Prodi>("Prodi")
        if (prodi != null) {
            val imgPhoto: ImageView = findViewById(R.id.imageView2)
            val tvName: TextView = findViewById(R.id.textView2)
            val tvDesc: TextView = findViewById(R.id.textView3)

            imgPhoto.setImageResource(prodi.img)
            tvName.text = prodi.title
            tvDesc.text = prodi.desc
        }
    }
}