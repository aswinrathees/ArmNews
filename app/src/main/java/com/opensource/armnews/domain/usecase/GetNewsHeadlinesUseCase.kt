package com.opensource.armnews.domain.usecase

import com.opensource.armnews.data.model.APIResponse
import com.opensource.armnews.data.util.Resource
import com.opensource.armnews.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines()
    }
}