package com.deepak.jetpack_compose_api.data

import com.deepak.jetpack_compose_api.data.model.NewsModel
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiService: ApiService
) : INewsRepository {

    override suspend fun getNews(): NewsModel {
        return apiService.getNews()
    }
}