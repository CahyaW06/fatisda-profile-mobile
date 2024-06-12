package com.example.fatisdaprofilemobile.ui.profil

import android.os.Bundle

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fatisdaprofilemobile.R

class DetailPengajarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pengajar)

        // Menerima data dari intent
        val nama = intent.getStringExtra("NAMA")
        val email = intent.getStringExtra("EMAIL")
        val imgResId = intent.getIntExtra("IMG", -1)
        val prodi = intent.getStringExtra("PRODI") // Tambahkan ini

        // Menampilkan data di layout
        val imgDosen: ImageView = findViewById(R.id.img_dosen_detail)
        val txtNamaDosen: TextView = findViewById(R.id.txt_nama_dosen_detail)
        val txtEmailDosen: TextView = findViewById(R.id.txt_email_dosen_detail)
        val txtProdiDosen: TextView = findViewById(R.id.txt_prodi_dosen_detail)

        imgDosen.setImageResource(imgResId)
        txtNamaDosen.text = nama
        txtEmailDosen.text = email
        txtProdiDosen.text = prodi
    }
}


