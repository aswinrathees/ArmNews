package com.opensource.armnews.data.repository.datasource

import com.opensource.armnews.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    suspend fun saveArticlesToDB(article: Article)
    suspend fun deleteArticlesFromDB(article: Article)
    fun getSavedArticles(): Flow<List<Article>>
}