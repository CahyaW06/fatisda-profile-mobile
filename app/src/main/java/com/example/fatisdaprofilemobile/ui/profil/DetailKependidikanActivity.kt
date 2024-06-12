package com.example.fatisdaprofilemobile.ui.profil

import android.os.Bundle

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fatisdaprofilemobile.R

class DetailKependidikanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kependidikan)

        val imgTendikDetail: ImageView = findViewById(R.id.img_tendik_detail)
        val txtNamaTendikDetail: TextView = findViewById(R.id.txt_nama_tendik_detail)
        val txtJabatanDetail: TextView = findViewById(R.id.txt_jabatan_tendik_detail)

        val intent = intent
        val nama = intent.getStringExtra("NAMA")
        val jabatan = intent.getStringExtra("JABATAN")
        val img = intent.getIntExtra("IMG", 0)

        imgTendikDetail.setImageResource(img)
        txtNamaTendikDetail.text = nama
        txtJabatanDetail.text = jabatan
    }
}
