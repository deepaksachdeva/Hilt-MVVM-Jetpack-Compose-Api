package com.deepak.jetpack_compose_api.ui.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepak.jetpack_compose_api.data.NewsRepository
import com.deepak.jetpack_compose_api.data.model.NewsArticle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _newsArticlesFlow: MutableStateFlow<List<NewsArticle>> =
        MutableStateFlow(emptyList())
    val newsArticlesFlow: StateFlow<List<NewsArticle>>
        get() = _newsArticlesFlow

    init {
        viewModelScope.launch {
            _newsArticlesFlow.value = newsRepository.getNews().articles
        }
    }
}