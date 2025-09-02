package com.opensource.armnews.data.repository

import com.opensource.armnews.data.model.APIResponse
import com.opensource.armnews.data.model.Article
import com.opensource.armnews.data.repository.datasource.NewsLocalDataSource
import com.opensource.armnews.data.repository.datasource.NewsRemoteDataSource
import com.opensource.armnews.data.util.Resource
import com.opensource.armnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {

    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResult(newsRemoteDataSource.getNewsHeadlines(country, page))
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResult(newsRemoteDataSource.getSearchedNews(country, searchQuery, page))
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticlesToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsLocalDataSource.deleteArticlesFromDB(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDataSource.getSavedArticles()
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