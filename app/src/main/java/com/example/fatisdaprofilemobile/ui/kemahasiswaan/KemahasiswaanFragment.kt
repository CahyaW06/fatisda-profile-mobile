package com.example.fatisdaprofilemobile.ui.kemahasiswaan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fatisdaprofilemobile.R
import com.example.fatisdaprofilemobile.databinding.FragmentKemahasiswaanBinding

class KemahasiswaanFragment : Fragment() {

    private var _binding: FragmentKemahasiswaanBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var rvNews: RecyclerView
    private val list = ArrayList<News>()

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
    }

    private fun getListNews() : ArrayList<News> {
        val dataTitle = resources.getStringArray(R.array.news_title)
        val dataBody = resources.getStringArray(R.array.news_body)
        val dataImg = resources.obtainTypedArray(R.array.news_img)
        val listNews = ArrayList<News>()
        for (i in dataTitle.indices) {
            val news = News(dataTitle[i], dataBody[i], dataImg.getResourceId(i, -1))
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
//        Toast.makeText(context, news.title.replace(" ", "-"), Toast.LENGTH_SHORT).show()
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://uns.ac.id/id/tag/fatisda-uns/".plus(news.title.replace(" ", "-")).plus(".html")))
        startActivity(intent)
    }
}