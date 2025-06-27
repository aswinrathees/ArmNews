package com.opensource.armnews.domain.usecase

import com.opensource.armnews.domain.repository.NewsRepository

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
}