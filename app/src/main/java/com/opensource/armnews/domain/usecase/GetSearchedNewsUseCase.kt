package com.opensource.armnews.domain.usecase

import com.opensource.armnews.data.model.APIResponse
import com.opensource.armnews.data.util.Resource
import com.opensource.armnews.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, searchQuery: String, page: Int): Resource<APIResponse> {
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }
}