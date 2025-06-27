package com.opensource.armnews.domain.usecase

import com.opensource.armnews.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}