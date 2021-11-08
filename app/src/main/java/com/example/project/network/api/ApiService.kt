package com.example.project.network.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {

        val agentService by lazy { createService() }
        val rankService by lazy { createSecondService() }

        private val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private fun createService(): AgentNetwork {
            val retrofitBuilder = Retrofit.Builder()
            retrofitBuilder.baseUrl("https://valorant-api.com/v1/")
            retrofitBuilder.client(
                OkHttpClient().newBuilder()
                    .addInterceptor(loggingInterceptor)
                    .build()
            )
            retrofitBuilder.addConverterFactory(mochiConvertor())
            return retrofitBuilder.build().create(AgentNetwork::class.java)
        }
        private fun createSecondService(): AgentNetwork {
            val retrofitBuilder = Retrofit.Builder()
            retrofitBuilder.baseUrl("https://eu.api.riotgames.com/val/ranked/v1/leaderboards/by-act/")
            retrofitBuilder.client(
                OkHttpClient().newBuilder()
                    .addInterceptor(loggingInterceptor)
                    .build()
            )
            retrofitBuilder.addConverterFactory(mochiConvertor())
            return retrofitBuilder.build().create(AgentNetwork::class.java)
        }

        private fun mochiConvertor()=
            MoshiConverterFactory.create(
                Moshi.Builder().addLast(KotlinJsonAdapterFactory())
                    .build()
            )
}
