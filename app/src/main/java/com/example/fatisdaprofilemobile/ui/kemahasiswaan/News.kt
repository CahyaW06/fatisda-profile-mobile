package com.example.fatisdaprofilemobile.ui.kemahasiswaan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title: String,
    val body: String,
    val img: Int
) : Parcelable