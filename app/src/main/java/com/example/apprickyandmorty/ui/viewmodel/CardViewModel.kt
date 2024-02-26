package com.example.apprickyandmorty.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apprickyandmorty.data.model.Card
import com.example.apprickyandmorty.data.model.DataCard
import com.example.apprickyandmorty.data.model.ResultX
import com.example.apprickyandmorty.domain.GetCardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    private val getQuoteUseCase: GetCardUseCase
): ViewModel() {
    val quoteModel = MutableLiveData<List<ResultX>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuoteUseCase()
            val listCardData: List<ResultX>? = result?.results
            println("resultado "+ listCardData?.get(1)!!.name)
                quoteModel.postValue(listCardData!!)
                isLoading.postValue(false)
        }
    }
}
