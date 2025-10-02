package com.opensource.armnews.domain.usecase

import com.opensource.armnews.data.model.Article
import com.opensource.armnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}