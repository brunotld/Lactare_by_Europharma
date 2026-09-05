package com.example.lactare.model

data class QuizQuestion(
    val id: Int,
    val question: String,
    val options: List<String>
)