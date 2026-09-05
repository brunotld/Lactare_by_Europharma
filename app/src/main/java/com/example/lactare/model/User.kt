package com.example.lactare.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val address: String,
    val totalDonatedMl: Int,
    val babiesHelped: Int
)