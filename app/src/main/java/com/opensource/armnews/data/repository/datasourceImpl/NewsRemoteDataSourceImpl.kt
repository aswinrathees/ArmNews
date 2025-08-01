package com.opensource.armnews.data.repository.datasourceImpl

import com.opensource.armnews.data.api.NewsAPIService
import com.opensource.armnews.data.model.APIResponse
import com.opensource.armnews.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int): NewsRemoteDataSource {

    override suspend fun getNewsHeadlines(): Response<APIResponse> {
        return newsAPIService.getNewsHeadlines(country, page, "")
    }

    override suspend fun getSearchedNews(searchQuery: String): Response<APIResponse> {
        TODO("Not yet implemented")
    }
}