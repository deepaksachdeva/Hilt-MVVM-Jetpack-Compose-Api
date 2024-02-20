package com.deepak.jetpack_compose_api.data.model

data class NewsModel(
    val status: String,
    val totalResults: String,
    val articles: List<NewsArticle>
)