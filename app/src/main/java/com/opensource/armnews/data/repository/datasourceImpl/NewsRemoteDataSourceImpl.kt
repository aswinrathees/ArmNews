package com.opensource.armnews.data.repository.datasourceImpl

import com.opensource.armnews.data.api.NewsAPIService
import com.opensource.armnews.data.model.APIResponse
import com.opensource.armnews.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
) : NewsRemoteDataSource {

    override suspend fun getNewsHeadlines(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getNewsHeadlines(country, page)
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getSearchedTopHeadlines(country, page, searchQuery)
    }
}