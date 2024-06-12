package com.example.fatisdaprofilemobile.ui.profil

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Text(
    val name: String,
    val desc: String,
    val img: Int
) : Parcelable