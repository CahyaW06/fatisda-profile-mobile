package com.example.fatisdaprofilemobile.ui.prodi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Prodi(
    val title: String,
    val desc: String,
    val img: Int
) :Parcelable