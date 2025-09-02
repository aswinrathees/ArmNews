package com.opensource.armnews.data.repository.datasourceImpl

import com.opensource.armnews.data.db.ArticleDAO
import com.opensource.armnews.data.model.Article
import com.opensource.armnews.data.repository.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(private val articleDao: ArticleDAO) : NewsLocalDataSource {
    override suspend fun saveArticlesToDB(article: Article) {
        articleDao.insert(article)
    }

    override suspend fun deleteArticlesFromDB(article: Article) {
        articleDao.deleteArticle(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }
}