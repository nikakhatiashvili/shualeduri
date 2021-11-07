package com.example.project.network.officialapi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object OfficialApiService {

    val agentService by lazy { createService() }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun createService(): RankNetwork {
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.baseUrl("https://eu.api.riotgames.com/val/ranked/v1/leaderboards/by-act/")
        retrofitBuilder.client(
            OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .build()
        )
        retrofitBuilder.addConverterFactory(mochiConvertor())
        return retrofitBuilder.build().create(RankNetwork::class.java)
    }

    private fun mochiConvertor()=
        MoshiConverterFactory.create(
            Moshi.Builder().addLast(KotlinJsonAdapterFactory())
                .build()
        )
}
