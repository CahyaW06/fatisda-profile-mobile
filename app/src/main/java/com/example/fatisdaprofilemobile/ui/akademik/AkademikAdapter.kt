package com.example.fatisdaprofilemobile.ui.akademik

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.fatisdaprofilemobile.R

class AkademikAdapter(private val context: Context) :
    RecyclerView.Adapter<AkademikAdapter.AkademikViewHolder>() {

    private val judulAkademik = context.resources.getStringArray(R.array.judul_akademik)
    private val tanggalAkademik = context.resources.getStringArray(R.array.tanggal_akademik)
    private val deskripsiAkademik = context.resources.getStringArray(R.array.deskripsi_akademik)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AkademikViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_akademik, parent, false)
        return AkademikViewHolder(view)
    }

    override fun onBindViewHolder(holder: AkademikViewHolder, position: Int) {
        holder.tvTitle.text = judulAkademik[position]
        holder.tvDate.text = tanggalAkademik[position]
        holder.tvDescription.text = deskripsiAkademik[position]

        holder.cardView.setOnClickListener {
            val intent = Intent(context, DetailAkademikActivity::class.java).apply {
                putExtra("title", judulAkademik[position])
                putExtra("date", tanggalAkademik[position])
                putExtra("description", deskripsiAkademik[position])
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = judulAkademik.size

    inner class AkademikViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvDate: TextView = itemView.findViewById(R.id.tv_date)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }
}
