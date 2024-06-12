package com.example.fatisdaprofilemobile.ui.profil

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fatisdaprofilemobile.R

class PengajarAdapter(
    private val context: Context,
    private val fotoDosen: IntArray,
    private val namaDosen: Array<String>,
    private val emailDosen: Array<String>,
    private val prodiDosen: Array<String>
) : RecyclerView.Adapter<PengajarAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgDosen: ImageView = view.findViewById(R.id.img_dosen)
        val txtNamaDosen: TextView = view.findViewById(R.id.txt_namaDosen)
        val txtEmailDosen: TextView = view.findViewById(R.id.txt_emailDosen)
        val txtProdiDosen: TextView = view.findViewById(R.id.txt_prodiDosen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dosen, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgDosen.setImageResource(fotoDosen[position])
        holder.txtNamaDosen.text = namaDosen[position]
        holder.txtEmailDosen.text = emailDosen[position]
        holder.txtProdiDosen.text = prodiDosen[position]


        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailPengajarActivity::class.java).apply {
                putExtra("NAMA", namaDosen[position])
                putExtra("EMAIL", emailDosen[position])
                putExtra("IMG", fotoDosen[position])
                putExtra("PRODI", prodiDosen[position])
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return namaDosen.size
    }
}
