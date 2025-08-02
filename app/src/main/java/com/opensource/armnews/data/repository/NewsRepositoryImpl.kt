package com.opensource.armnews.data.repository

import com.opensource.armnews.data.model.APIResponse
import com.opensource.armnews.data.model.Article
import com.opensource.armnews.data.repository.datasource.NewsRemoteDataSource
import com.opensource.armnews.data.util.Resource
import com.opensource.armnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(private val newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {

    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResult(newsRemoteDataSource.getNewsHeadlines(country, page))
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    private fun responseToResult(response: Response<APIResponse>): Resource<APIResponse> {
        return if (response.isSuccessful) {
            response.body()?.let { result ->
                Resource.Success(result)
            } ?: Resource.Error("Response body was null. HTTP Code: ${response.code()}")
        } else {
            val errorMsg = response.errorBody()?.string() ?: "Unknown error"
            Resource.Error("HTTP ${response.code()}: $errorMsg")
        }
    }
}