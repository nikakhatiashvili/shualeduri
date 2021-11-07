package com.example.project.network.api

import com.example.project.model.agents.Agents
import com.example.project.model.maps.Maps
import com.example.project.model.sprays.Sprays
import com.example.project.model.weapons.Weapons
import retrofit2.Response
import retrofit2.http.GET

interface AgentNetwork {
    @GET("agents")
    suspend fun getAllCharacters(): Response<Agents>

    @GET("weapons")
    suspend fun getAllWeapons(): Response<Weapons>

    @GET("maps")
    suspend fun getAllMaps(): Response<Maps>

    @GET("sprays")
    suspend fun getAllSprays(): Response<Sprays>


}