package com.example.fatisdaprofilemobile.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fatisdaprofilemobile.R

class PengajarFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var pengajarAdapter: PengajarAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pengajar, container, false)
        recyclerView = view.findViewById(R.id.recycler_view_dosen)

        val namaDosen = resources.getStringArray(R.array.nama_dosen)
        val emailDosen = resources.getStringArray(R.array.email_dosen)
        val fotoDosen = resources.obtainTypedArray(R.array.foto_dosen)
        val prodiDosen = resources.getStringArray(R.array.prodi_dosen)
        val imgResIds = IntArray(fotoDosen.length()) { i -> fotoDosen.getResourceId(i, -1) }
        fotoDosen.recycle()

        pengajarAdapter = PengajarAdapter(requireContext(), imgResIds, namaDosen, emailDosen, prodiDosen)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = pengajarAdapter

        return view
    }
}