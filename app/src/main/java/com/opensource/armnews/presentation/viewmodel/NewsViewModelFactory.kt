package com.opensource.armnews.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.opensource.armnews.domain.usecase.DeleteSavedNewsUseCase
import com.opensource.armnews.domain.usecase.GetNewsHeadlinesUseCase
import com.opensource.armnews.domain.usecase.GetSavedNewsUseCase
import com.opensource.armnews.domain.usecase.GetSearchedNewsUseCase
import com.opensource.armnews.domain.usecase.SaveNewsUseCase

class NewsViewModelFactory(
    private val application: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            application,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsUseCase
        ) as T
    }
}