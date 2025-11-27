package com.example.myapp.data

data class Category(
    val id: Int,
    val name: String
)

data class Place(
    val id: Int,
    val categoryId: Int,
    val title: String,
    val description: String,
    val isFavorite: Boolean = false
)