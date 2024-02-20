package com.deepak.jetpack_compose_api.di

import com.deepak.jetpack_compose_api.data.ApiService
import com.deepak.jetpack_compose_api.data.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        apiService: ApiService,
    ): NewsRepository {
        return NewsRepository(
            apiService
        )
    }

//    @Singleton
//    @Binds
//    fun provideNewsRepository(
//        movieRepository: MovieRepository
//    ): INewsRepository
}