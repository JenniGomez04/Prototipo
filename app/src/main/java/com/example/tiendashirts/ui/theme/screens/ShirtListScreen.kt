// Dibuja la pantalla con todas las camisas (título y grilla u columnas).

package com.example.tiendashirts.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tiendashirts.ui.theme.components.BottomNavBar
import com.example.tiendashirts.ui.theme.components.FilterSection
import com.example.tiendashirts.ui.theme.components.ShirtCard
import com.example.tiendashirts.viewModel.ShirtListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShirtListScreen(
    onShirtClick: (Int) -> Unit,
    onBackClick: () -> Unit = {},
    vm: ShirtListViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "SHIRTS",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        // Importar menu principal
        bottomBar = {
            BottomNavBar()
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            // Filtros funcionando
            FilterSection()

            // Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(vm.shirts) { shirt ->
                    ShirtCard(
                        shirt = shirt,
                        onClick = { onShirtClick(shirt.id) },
                        onFavoriteClick = { vm.toggleFavorite(shirt.id) }
                    )
                }
            }
        }
    }
}
