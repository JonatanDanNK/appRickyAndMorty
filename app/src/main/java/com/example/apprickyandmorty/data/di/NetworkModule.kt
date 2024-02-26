package com.example.apprickyandmorty.data.di

import com.example.apprickyandmorty.data.network.CardApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providerRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/character/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providerCardApiClient(retrofit: Retrofit): CardApiClient {
        return retrofit.create(CardApiClient::class.java)
    }

}