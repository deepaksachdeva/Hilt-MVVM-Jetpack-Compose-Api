package com.deepak.jetpack_compose_api.data

import com.deepak.jetpack_compose_api.data.model.NewsModel

interface INewsRepository {

    suspend fun getNews(): NewsModel
}