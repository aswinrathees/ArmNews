package com.opensource.armnews.presentation.di

import com.opensource.armnews.data.repository.NewsRepositoryImpl
import com.opensource.armnews.data.repository.datasource.NewsLocalDataSource
import com.opensource.armnews.data.repository.datasource.NewsRemoteDataSource
import com.opensource.armnews.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource)
    }
}