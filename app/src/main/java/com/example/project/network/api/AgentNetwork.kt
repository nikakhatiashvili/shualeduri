package com.example.project.network.api

import com.example.project.model.agents.Agents
import com.example.project.model.maps.Maps
import com.example.project.model.ranks.Ranks
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

    @GET("a16955a5-4ad0-f761-5e9e-389df1c892fb?size=200&startIndex=0&api_key=RGAPI-8518e4e3-9a94-4f82-8296-b5cc66f3d5c5")
    suspend fun getAllRanks(): Response<Ranks>

}