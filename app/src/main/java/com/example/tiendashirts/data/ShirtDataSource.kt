package com.example.tiendashirts.data

import com.example.tiendashirts.R

object ShirtDataSource {
    fun getAll(): List<Shirt> = listOf(
        Shirt(
            id = 1,
            name = "Camisa de Algodón",
            price = "$24.00",
            images = listOf(
                R.drawable.shirt_sample_1,
                R.drawable.shirt_sample_2,
                R.drawable.shirt_sample_3,
                R.drawable.shirt_sample_4
            )
        ),
        Shirt(
            id = 2,
            name = "Camisa Slim Fit",
            price = "$15.00",
            images = listOf(
                R.drawable.shirt_sample_2,
                R.drawable.shirt_sample_1,
                R.drawable.shirt_sample_3,
                R.drawable.shirt_sample_4
            )
        ),
        Shirt(
            id = 3,
            name = "Camisa Casual",
            price = "$18.00",
            images = listOf(
                R.drawable.shirt_sample_3,
                R.drawable.shirt_sample_1,
                R.drawable.shirt_sample_2,
                R.drawable.shirt_sample_4
            )
        ),
        Shirt(
            id = 4,
            name = "Vestido Rojo",
            price = "$30.00",
            images = listOf(
                R.drawable.shirt_sample_4,
                R.drawable.shirt_sample_1,
                R.drawable.shirt_sample_2,
                R.drawable.shirt_sample_3,
            )
        )
    )
}

