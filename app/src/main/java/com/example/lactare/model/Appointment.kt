package com.example.lactare.model

data class Appointment(
    val id: Int,
    val date: String,
    val time: String,
    val address: String,
    val collectorName: String,
    val status: String
)