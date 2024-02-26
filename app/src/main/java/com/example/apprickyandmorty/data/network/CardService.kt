package com.example.apprickyandmorty.data.network

import com.example.apprickyandmorty.data.model.Card
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CardService @Inject constructor(private val api: CardApiClient){

    suspend fun getCard():Card{
        return withContext(Dispatchers.IO){
            val response = api.getAllCard()
            response.body()!!
        }
    }
}