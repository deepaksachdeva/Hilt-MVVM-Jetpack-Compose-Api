package com.deepak.jetpack_compose_api.ui.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.deepak.jetpack_compose_api.data.model.NewsArticle

@Composable
fun HomeScreen(navigation: (NewsArticle) -> Unit) {
    val mainViewModel = hiltViewModel<HomeViewModel>()
    val newsList by mainViewModel.newsArticlesFlow.collectAsState()

    Column {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            items(items = newsList) { news ->
                NewsItem(news) {
                    navigation(news)
                }
            }
        }
    }
}