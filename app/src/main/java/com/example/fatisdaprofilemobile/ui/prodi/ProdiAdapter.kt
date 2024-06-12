package com.example.fatisdaprofilemobile.ui.prodi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fatisdaprofilemobile.R

class ProdiAdapter(private val prodi: ArrayList<Prodi>): RecyclerView.Adapter<ProdiAdapter.ProdiViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    class ProdiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val prodiImage: ImageView = itemView.findViewById(R.id.prodi_image)
        val prodiTitle: TextView = itemView.findViewById(R.id.prodi_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdiViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_prodi, parent, false)
        return ProdiViewHolder(view)
    }

    override fun getItemCount(): Int = prodi.size

    override fun onBindViewHolder(holder: ProdiViewHolder, position: Int) {
        val (title, desc, img) = prodi[position]
        holder.prodiImage.setImageResource(img)
        holder.prodiTitle.text = title
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(prodi[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Prodi)
    }


}