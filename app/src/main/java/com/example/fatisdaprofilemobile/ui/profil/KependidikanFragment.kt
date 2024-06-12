package com.example.fatisdaprofilemobile.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fatisdaprofilemobile.R

class KependidikanFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var kependidikanAdapter:KependidikanAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_kependidikan, container, false)
        recyclerView = view.findViewById(R.id.recycler_view_tendik)

        val namaTendik = resources.getStringArray(R.array.nama_tendik)
        val fotoTendik = resources.obtainTypedArray(R.array.foto_tendik)
        val jabatanTendik = resources.getStringArray(R.array.jabatan_tendik)
        val imgTendikResIds = IntArray(fotoTendik.length()) { i -> fotoTendik.getResourceId(i, -1) }
        fotoTendik.recycle()

        kependidikanAdapter = KependidikanAdapter(requireContext(), imgTendikResIds, namaTendik, jabatanTendik)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = kependidikanAdapter

        return view
    }
}