package com.opensource.armnews.presentation.di

import com.opensource.armnews.BuildConfig
import com.opensource.armnews.data.api.NewsAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor = Interceptor { chain ->
            val originalRequest = chain.request()
            val requestWithUserAgent =
                originalRequest.newBuilder().header("User-Agent", "ArmNewsApp/1.0").build()
            chain.proceed(requestWithUserAgent)
        }
        val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor)
        return Retrofit.Builder()
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.API_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsAPIService(retrofit: Retrofit): NewsAPIService {
        return retrofit.create(NewsAPIService::class.java)
    }
}