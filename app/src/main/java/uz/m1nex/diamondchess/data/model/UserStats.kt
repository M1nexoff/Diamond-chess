package uz.m1nex.diamondchess.data.model

data class UserStats(
    val wins: Int,
    val losses: Int,
    val draws: Int
)

data class User(
    val name: String,
    val rating: Int,
    val stats: UserStats
)