package com.example.lactare.model

data class Donation(
    val id: Int,
    val userId: Int,
    val date: String,
    val time: String,
    val volumeMl: Int,
    val status: String
)