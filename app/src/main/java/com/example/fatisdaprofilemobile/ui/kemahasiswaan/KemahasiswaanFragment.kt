package com.example.fatisdaprofilemobile.ui.kemahasiswaan

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.CalendarContract.Colors
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.example.fatisdaprofilemobile.R
import com.example.fatisdaprofilemobile.databinding.FragmentKemahasiswaanBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate


class KemahasiswaanFragment : Fragment() {
    private var _binding: FragmentKemahasiswaanBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var rvNews: RecyclerView
    private val list = ArrayList<News>()
    private val pieEntries = ArrayList<PieEntry>()

    private val handler = Handler(Looper.getMainLooper())
    private lateinit var scrollRunnable: Runnable
    private var currentIndex = 0
    private val scrollDelay = 5000

    private lateinit var pieChart: PieChart

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {return inflater.inflate(R.layout.fragment_kemahasiswaan, container, false)}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvNews = view.findViewById(R.id.rv_berita)
        rvNews.setHasFixedSize(true)

        list.addAll(getListNews())
        showRecyclerList()

        pieChart = view.findViewById(R.id.pieChart);
        pieEntries.add(PieEntry(551f, "Mahasiswa"))
        pieEntries.add(PieEntry(17f, "Dosen"))
        pieEntries.add(PieEntry(556f, "Alumni"))

        val pieDataSet = PieDataSet(pieEntries, "");
        pieDataSet.setColors(ColorTemplate.PASTEL_COLORS.asList());
        pieDataSet.valueTextSize = 10f;
        pieDataSet.valueTextColor = Color.WHITE;

        val pieLegend = pieChart.legend
        pieLegend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        pieLegend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER

        val pieData = PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setEntryLabelTextSize(10f);
        pieChart.animateY(1000);

        pieChart.invalidate();

        val himaBtn = view.findViewById<Button>(R.id.hima_btn)
        himaBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://himaster.fatisda.uns.ac.id/"))
            startActivity(intent)
        }

        initAutoScroll()
    }

    private fun getListNews() : ArrayList<News> {
        val dataTitle = resources.getStringArray(R.array.news_title)
        val dataBody = resources.getStringArray(R.array.news_body)
        val dataImg = resources.obtainTypedArray(R.array.news_img)
        val dataMainNews = resources.getStringArray(R.array.news_main)
        val dataDate = resources.getStringArray(R.array.news_date)
        val listNews = ArrayList<News>()
        for (i in dataTitle.indices) {
            val news = News(dataTitle[i], dataBody[i], dataImg.getResourceId(i, -1), dataMainNews[i], dataDate[i])
            listNews.add(news)
        }
        return listNews
    }

    private fun showRecyclerList() {
        rvNews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val listNewsAdapter = ListNewsAdapter(list)
        rvNews.adapter = listNewsAdapter

        listNewsAdapter.setOnItemClickCallback(object : ListNewsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: News) {
                showSelectedNews(data)
            }
        })
    }

    private fun showSelectedNews(news: News) {
        val intent = Intent(context, NewsDetail::class.java).apply {
            putExtra("Berita", news)
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
            rvNews.layoutManager?.startSmoothScroll(smoothScroller)
            handler.postDelayed(scrollRunnable, scrollDelay.toLong()) // Scroll every `scrollDelay` milliseconds
        }
        handler.postDelayed(scrollRunnable, scrollDelay.toLong()) // Initial delay of `scrollDelay` milliseconds
    }


}