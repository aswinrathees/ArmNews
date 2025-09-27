package com.opensource.armnews.presentation.di

import android.app.Application
import com.opensource.armnews.domain.usecase.DeleteSavedNewsUseCase
import com.opensource.armnews.domain.usecase.GetNewsHeadlinesUseCase
import com.opensource.armnews.domain.usecase.GetSavedNewsUseCase
import com.opensource.armnews.domain.usecase.GetSearchedNewsUseCase
import com.opensource.armnews.domain.usecase.SaveNewsUseCase
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
    fun getNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSavedNewsUseCase: GetSavedNewsUseCase,
        deleteSavedNewsUseCase: DeleteSavedNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsUseCase
        )
    }
}