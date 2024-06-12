package com.example.fatisdaprofilemobile.ui.prodi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.example.fatisdaprofilemobile.R
import com.example.fatisdaprofilemobile.databinding.FragmentProdiBinding

class ProdiFragment : Fragment() {
    private var _binding: FragmentProdiBinding? = null
    private lateinit var recyclerView: RecyclerView
    private val list = ArrayList<Prodi>()
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var scrollRunnable: Runnable
    private var currentIndex = 0
    private val scrollDelay = 5000
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {return inflater.inflate(R.layout.fragment_prodi, container, false)}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview_prodi)
        recyclerView.setHasFixedSize(true)

        list.addAll(getListProdi())
        showRecyclerList()

        val informatikaBtn = view.findViewById<Button>(R.id.informatika_button)
        informatikaBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://if.fatisda.uns.ac.id/"))
            startActivity(intent)
        }

        val sainsDataBtn = view.findViewById<Button>(R.id.sainsData_button)
        sainsDataBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://sd.fatisda.uns.ac.id/"))
            startActivity(intent)
        }

        initAutoScroll()
    }

    private fun showRecyclerList() {
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val prodiAdapter = ProdiAdapter(list)
        recyclerView.adapter = prodiAdapter

        prodiAdapter.setOnItemClickCallback(object : ProdiAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Prodi) {
                showSelectedProdi(data)
            }
        })
    }

    private fun getListProdi(): Collection<Prodi> {
        val dataFotoProdi = resources.obtainTypedArray(R.array.data_fotoProdi)
        val dataTitleProdi = resources.getStringArray(R.array.data_namaProdi)
        val dataDeskripsiProdi = resources.getStringArray(R.array.data_deskripsiprodi)
        val listHero = ArrayList<Prodi>()
        for (i in dataTitleProdi.indices) {
            val hero = Prodi(dataTitleProdi[i], dataDeskripsiProdi[i],dataFotoProdi.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero

    }

    private fun showSelectedProdi(prodi: Prodi) {
        val intent = Intent(context, DetailProdi::class.java).apply {
            putExtra("Prodi", prodi)
        }
        startActivity(intent)
    }

    private fun initAutoScroll() {
        val smoothScroller = object : LinearSmoothScroller(context) {
            override fun calculateSpeedPerPixel(displayMetrics: android.util.DisplayMetrics): Float {
                return 100f / displayMetrics.densityDpi // Adjust the value to control the speed, smaller make faster
            }
        }

        scrollRunnable = Runnable {
            currentIndex++
            if (currentIndex >= list.size) {
                currentIndex = 0
            }
            smoothScroller.targetPosition = currentIndex
            recyclerView.layoutManager?.startSmoothScroll(smoothScroller)
            handler.postDelayed(scrollRunnable, scrollDelay.toLong()) // Scroll every `scrollDelay` milliseconds
        }
        handler.postDelayed(scrollRunnable, scrollDelay.toLong()) // Initial delay of `scrollDelay` milliseconds
    }
}