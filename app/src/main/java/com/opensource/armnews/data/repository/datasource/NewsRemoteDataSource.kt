package com.opensource.armnews.data.repository.datasource

import com.opensource.armnews.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getNewsHeadlines(): Response<APIResponse>
    suspend fun getSearchedNews(searchQuery: String): Response<APIResponse>
}