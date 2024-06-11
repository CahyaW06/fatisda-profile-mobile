package com.example.fatisdaprofilemobile.ui.kemahasiswaan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fatisdaprofilemobile.R

class ListNewsAdapter(private val listNews: ArrayList<News>) : RecyclerView.Adapter<ListNewsAdapter.ListViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView: ImageView = itemView.findViewById(R.id.rv_item_berita_img)
        val tvTitle: TextView = itemView.findViewById(R.id.rv_item_berita_title)
        val tvDate: TextView = itemView.findViewById(R.id.rv_item_berita_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_berita, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listNews.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, body, img, mainNews, date) = listNews[position]
        holder.imgView.setImageResource(img)
        holder.tvTitle.text = title
        holder.tvDate.text = date
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listNews[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: News)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

}