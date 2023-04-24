package com.dicoding.rajendra.jettixid.model

data class Movie(
    val id: Long,
    val title: String,
    val year: String,
    val posterUrl: String,
    val synopsis: String,
    val director: String,
    val genre: String,
    val duration: String,

    val image: Int,
    val requiredPoint: Int,
)