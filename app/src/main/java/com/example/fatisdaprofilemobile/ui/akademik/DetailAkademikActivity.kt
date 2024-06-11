package com.example.fatisdaprofilemobile.ui.akademik

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fatisdaprofilemobile.R

class DetailAkademikActivity : AppCompatActivity() {

    private lateinit var tvDetailTitle: TextView
    private lateinit var tvDetailDate: TextView
    private lateinit var tvDetailDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_akademik)

        tvDetailTitle = findViewById(R.id.tv_judul_akademik)
        tvDetailDate = findViewById(R.id.tv_tanggal_akademik)
        tvDetailDescription = findViewById(R.id.tv_deskripsi_akademik)

        val title = intent.getStringExtra("title")
        val date = intent.getStringExtra("date")
        val description = intent.getStringExtra("description")

        tvDetailTitle.text = title
        tvDetailDate.text = date
        tvDetailDescription.text = description
    }
}
