package com.example.fatisdaprofilemobile.ui.akademik

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fatisdaprofilemobile.R

class AkademikFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var akademikAdapter: AkademikAdapter
    private lateinit var akademikList: MutableList<Akademik>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_akademik, container, false)
        recyclerView = view.findViewById(R.id.rv_akademik)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Inisialisasi akademikList
        akademikList = mutableListOf()

        // Ambil data dari strings.xml dan tambahkan ke akademikList
        val judulAkademikArray = resources.getStringArray(R.array.judul_akademik)
        val tanggalAkademikArray = resources.getStringArray(R.array.tanggal_akademik)
        val deskripsiAkademikArray = resources.getStringArray(R.array.deskripsi_akademik)

        for (i in judulAkademikArray.indices) {
            akademikList.add(
                Akademik(
                    judulAkademikArray[i],
                    deskripsiAkademikArray[i],
                    tanggalAkademikArray[i]
                )
            )
        }

        akademikAdapter = AkademikAdapter(requireContext()) // Menggunakan requireContext() untuk mendapatkan Context dari Fragment
        recyclerView.adapter = akademikAdapter

        return view
    }
}
