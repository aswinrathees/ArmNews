package com.opensource.armnews.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
//import mockwebserver3.MockResponse
//import mockwebserver3.MockWebServer
//import okio.buffer
//import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIServiceTest {

    // Todo: Uncomment when newer version of mockwebserver is available
    /*private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected() {
        runBlocking {
            enqueueMocResponse("newsresponse.json")
            val responseBody = service.getNewsHeadlines("us", 1, "26c06028babb404498dd8e7a820f6262").body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
        }
    }

    private fun enqueueMocResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse.Builder()
            .body(source.readString(Charsets.UTF_8))
            .build()
        server.enqueue(mockResponse)
    }

    @After
    fun tearDown() {
        server.close()
    }*/
}
