package com.opensource.armnews.domain.usecase

import com.opensource.armnews.data.model.Article
import com.opensource.armnews.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}