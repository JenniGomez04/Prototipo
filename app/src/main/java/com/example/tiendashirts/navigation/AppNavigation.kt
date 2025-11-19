// Controlar las pantallas (navegación)

package com.example.tiendashirts.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tiendashirts.data.ShirtDataSource
import com.example.tiendashirts.ui.theme.screens.ShirtDetailScreen
import com.example.tiendashirts.ui.theme.screens.ShirtListScreen

// Definimos las rutas (pantallas)
sealed class AppScreen(val route: String) {
    object ShirtList : AppScreen("shirt_list")
    object ShirtDetail : AppScreen("shirt_detail/{id}") {
        fun createRoute(id: Int) = "shirt_detail/$id"
    }
}

// Función composable que controla la navegación
@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.ShirtList.route
    ) {
        composable(AppScreen.ShirtList.route) {
            ShirtListScreen(
                onShirtClick = { id ->

                    navController.navigate(AppScreen.ShirtDetail.createRoute(id))
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
// Navegar a detalle
        composable(AppScreen.ShirtDetail.route) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: 0
            val shirt = ShirtDataSource.getAll().find { it.id == id }
            shirt?.let {
                ShirtDetailScreen(
                    shirt = it,
                    navController = navController)
            }
        }
    }
}
