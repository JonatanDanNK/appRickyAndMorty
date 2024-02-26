package com.example.apprickyandmorty.data.network

import com.example.apprickyandmorty.data.model.Card
import retrofit2.Response
import retrofit2.http.GET

interface CardApiClient {
    @GET("./?page=1")
    suspend fun getAllCard():Response<Card>
}