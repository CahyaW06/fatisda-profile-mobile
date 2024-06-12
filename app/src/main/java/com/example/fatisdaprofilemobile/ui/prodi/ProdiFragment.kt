package com.example.fatisdaprofilemobile.ui.prodi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fatisdaprofilemobile.R


class ProdiFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProdiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_prodi, container, false)
        recyclerView = view.findViewById(R.id.recyclerview_prodi)
        adapter = ProdiAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        return view
    }

}