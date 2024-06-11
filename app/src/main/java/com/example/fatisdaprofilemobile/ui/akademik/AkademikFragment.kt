package com.example.fatisdaprofilemobile.ui.akademik

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.os.Handler
import android.os.Looper
import com.example.fatisdaprofilemobile.R

class AkademikFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var akademikAdapter: AkademikAdapter
    private lateinit var akademikList: MutableList<Akademik>
    private lateinit var autoScrollRunnable: Runnable
    private lateinit var autoScrollHandler: Handler
    private var currentIndex = 0
    private val scrollDelay = 3000L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_akademik, container, false)
        recyclerView = view.findViewById(R.id.rv_akademik)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) // Set horizontal scroll

        recyclerView.isHorizontalScrollBarEnabled = false

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

        akademikAdapter = AkademikAdapter(requireContext())
        recyclerView.adapter = akademikAdapter

        // Implementasi aksi untuk tombol "KURIKULUM"
        val kurikulumBtn = view.findViewById<Button>(R.id.kurikulum_btn)
        kurikulumBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://if.fatisda.uns.ac.id/akademik/kurikulum/"))
            startActivity(intent)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        autoScrollHandler = Handler(Looper.getMainLooper())

        val smoothScroller: LinearSmoothScroller = object : LinearSmoothScroller(context) {
            override fun calculateSpeedPerPixel(displayMetrics: android.util.DisplayMetrics): Float {
                return 100f / displayMetrics.densityDpi // Adjust the value to control the speed, smaller make faster
            }
        }

        autoScrollRunnable = Runnable {
            currentIndex++
            if (currentIndex >= akademikList.size) {
                currentIndex = 0
            }
            smoothScroller.targetPosition = currentIndex
            recyclerView.layoutManager?.startSmoothScroll(smoothScroller)
            autoScrollHandler.postDelayed(autoScrollRunnable, scrollDelay)
        }

        autoScrollHandler.postDelayed(autoScrollRunnable, scrollDelay)
    }
}

