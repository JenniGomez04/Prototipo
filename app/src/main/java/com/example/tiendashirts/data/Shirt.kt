package com.example.tiendashirts.data

data class Shirt(
    val id: Int,
    val name: String,
    val price: String,
    val images: List<Int>,
    val isFavorite: Boolean = false
)