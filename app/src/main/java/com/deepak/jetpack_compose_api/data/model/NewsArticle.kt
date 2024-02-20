package com.deepak.jetpack_compose_api.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsArticle(
    val description: String?,
    val title: String?,
    val url: String,
    val urlToImage: String
) : Parcelable
