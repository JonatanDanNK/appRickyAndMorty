package com.example.apprickyandmorty.domain

import com.example.apprickyandmorty.data.CardRepository
import com.example.apprickyandmorty.data.model.Card
import javax.inject.Inject

class GetCardUseCase @Inject constructor( private val repository: CardRepository){
    suspend operator fun invoke():Card? = repository.getAllCard()
}