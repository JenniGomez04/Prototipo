package com.example.tiendashirts.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.tiendashirts.data.Shirt
import com.example.tiendashirts.data.ShirtDataSource

class ShirtListViewModel : ViewModel() {
    var shirts by mutableStateOf(ShirtDataSource.getAll())
        private set

    // Cambia el estado del favorito
    fun toggleFavorite(id: Int) {
        shirts = shirts.map { shirt ->
            if (shirt.id == id) shirt.copy(isFavorite = !shirt.isFavorite)
            else shirt
        }
    }
}