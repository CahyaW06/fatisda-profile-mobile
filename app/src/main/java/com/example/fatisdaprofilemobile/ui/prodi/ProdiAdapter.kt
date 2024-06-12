package com.example.fatisdaprofilemobile.ui.prodi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fatisdaprofilemobile.R

class ProdiAdapter: RecyclerView.Adapter<ProdiAdapter.ProdiViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdiAdapter.ProdiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_prodi, parent, false)
            return ProdiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdiAdapter.ProdiViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 25
    }

    class ProdiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}