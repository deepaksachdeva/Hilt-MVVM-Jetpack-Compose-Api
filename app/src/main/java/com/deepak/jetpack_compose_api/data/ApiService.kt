package com.deepak.jetpack_compose_api.data

import com.deepak.jetpack_compose_api.data.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "5dc2f9643c824ffdbe0348aca8746456"
    }

    //    https://newsapi.org/v2/everything?domains=wsj.com&apiKey=5dc2f9643c824ffdbe0348aca8746456
    @GET("everything")
    suspend fun getNews(
        @Query("domains") domains: String = "wsj.com",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsModel
}
