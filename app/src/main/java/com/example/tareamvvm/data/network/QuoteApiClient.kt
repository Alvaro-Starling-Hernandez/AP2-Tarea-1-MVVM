package com.example.tareamvvm.data.network

import com.example.tareamvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuote() : Response<List<QuoteModel>>

}