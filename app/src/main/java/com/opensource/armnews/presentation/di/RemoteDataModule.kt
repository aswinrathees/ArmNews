package com.opensource.armnews.presentation.di

import com.opensource.armnews.data.api.NewsAPIService
import com.opensource.armnews.data.repository.datasource.NewsRemoteDataSource
import com.opensource.armnews.data.repository.datasourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun getNewsRemoteDataSource(newsApiService: NewsAPIService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApiService)
    }
}