package com.example.fatisdaprofilemobile.ui.kemahasiswaan

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fatisdaprofilemobile.R

class NewsDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.news_page)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val newsData = intent.getParcelableExtra<News>("Berita")
        if (newsData != null) {
            val titleView: TextView = findViewById(R.id.news_main_title)
            val bodyView: TextView = findViewById(R.id.news_main_body)
            val imgView: ImageView = findViewById(R.id.news_main_img)
            val dateView: TextView = findViewById(R.id.news_main_date)

            titleView.text = newsData.title
            bodyView.text = HtmlCompat.fromHtml(newsData.mainNews, HtmlCompat.FROM_HTML_MODE_COMPACT)
            imgView.setImageResource(newsData.img)
            dateView.text = newsData.date
        }
    }
}