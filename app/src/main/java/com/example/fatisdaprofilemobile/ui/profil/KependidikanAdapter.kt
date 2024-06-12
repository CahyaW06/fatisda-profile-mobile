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

class KependidikanAdapter(
    private val context: Context,
    private val fotoTendik: IntArray,
    private val namaTendik: Array<String>,
    private val jabatanTendik: Array<String>
) : RecyclerView.Adapter<KependidikanAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgTendik: ImageView = view.findViewById(R.id.img_tendik)
        val txtNamaTendik: TextView = view.findViewById(R.id.txt_namaTendik)
        val txtJabatanTendik: TextView = view.findViewById(R.id.txt_jabatanTendik)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tendik, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgTendik.setImageResource(fotoTendik[position])
        holder.txtNamaTendik.text = namaTendik[position]
        holder.txtJabatanTendik.text = jabatanTendik[position]

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailKependidikanActivity::class.java).apply {
                putExtra("NAMA", namaTendik[position])
                putExtra("JABATAN", jabatanTendik[position])
                putExtra("IMG", fotoTendik[position])
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return namaTendik.size
    }
}
