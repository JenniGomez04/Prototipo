package com.example.tiendashirts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.NavigationBar
import com.example.tiendashirts.navigation.AppNavigation
import com.example.tiendashirts.ui.theme.TiendaShirtsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiendaShirtsTheme {
                AppNavigation()

            }
        }
    }
}
