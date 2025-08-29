package com.opensource.armnews.data.repository.datasource

import com.opensource.armnews.data.model.Article

interface NewsLocalDataSource {
    suspend fun saveArticlesToDB(article: Article)
}