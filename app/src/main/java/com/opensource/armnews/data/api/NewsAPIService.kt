package com.opensource.armnews.data.api

import com.opensource.armnews.BuildConfig
import com.opensource.armnews.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadlines(
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Response<APIResponse>

    @GET("v2/top-headlines")
    suspend fun getSearchedTopHeadlines(
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("q") searchQuery: String,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Response<APIResponse>
}