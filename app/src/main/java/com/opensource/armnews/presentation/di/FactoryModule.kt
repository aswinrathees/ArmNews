package com.opensource.armnews.presentation.di

import android.app.Application
import com.opensource.armnews.domain.usecase.GetNewsHeadlinesUseCase
import com.opensource.armnews.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun getNewsViewModelFactory(application: Application, getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase): NewsViewModelFactory {
        return NewsViewModelFactory(application, getNewsHeadlinesUseCase)
    }
}