package com.example.apprickyandmorty.data.model

import com.google.gson.annotations.SerializedName

data class Card(@SerializedName("results") val results: List<ResultX>)
