package com.apa.accenture.examplemvvm.data.network

import com.apa.accenture.examplemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}