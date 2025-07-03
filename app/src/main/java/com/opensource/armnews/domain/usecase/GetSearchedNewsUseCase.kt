package com.opensource.armnews.domain.usecase

import com.opensource.armnews.data.model.APIResponse
import com.opensource.armnews.data.util.Resource
import com.opensource.armnews.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}