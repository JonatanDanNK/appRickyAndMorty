package com.example.apprickyandmorty.data

import com.example.apprickyandmorty.data.model.Card
import com.example.apprickyandmorty.data.network.CardService
import javax.inject.Inject


class CardRepository @Inject constructor(private val api: CardService){//, private val quoteProvider:CardProvider){

    suspend fun getAllCard():Card{
        val response:Card = api.getCard()
        //quoteProvider.quotes = response
        return response
    }
}