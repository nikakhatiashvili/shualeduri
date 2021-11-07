package com.example.project.model.ranks

data class Ranks(
    val actId: String?,
    val immortalStartingIndex: Int?,
    val immortalStartingPage: Int?,
    val players: List<Player>?,
    val query: String?,
    val shard: String?,
    val startIndex: Int?,
    val tierDetails: TierDetails?,
    val topTierRRThreshold: Int?,
    val totalPlayers: Int?
)