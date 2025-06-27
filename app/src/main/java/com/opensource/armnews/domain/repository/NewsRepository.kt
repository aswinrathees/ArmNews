package com.opensource.armnews.domain.repository

import com.opensource.armnews.data.model.APIResponse

interface NewsRepository {

    suspend fun getNewsHeadlines(): APIResponse
}