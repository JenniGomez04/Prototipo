// Pantalla de Detalle para mostrar la imagen seleccionada

package com.example.tiendashirts.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tiendashirts.data.Shirt
import kotlinx.coroutines.launch
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShirtDetailScreen(
    shirt: Shirt,
    navController: NavHostController,
    onBackClick: () -> Unit = {},
    onFavoriteClick: () -> Unit = {},
    onAddToBag: () -> Unit = {}
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { shirt.images.size })
    val scope = rememberCoroutineScope()

    var selectedSize by remember { mutableStateOf("L") }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize()) {

            // CARRUSEL CON SCROLL
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFFE8E8E8)),
                contentAlignment = Alignment.Center
            ) {
                HorizontalPager(state = pagerState) { page ->
                    Image(
                        painter = painterResource(shirt.images[page]),
                        contentDescription = shirt.name,
                        modifier = Modifier
                            .fillMaxWidth() // tamaño de la imagen
                            .aspectRatio(0.75f),
                        contentScale = ContentScale.Fit
                    )
                }

                // PUNTICOS
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(shirt.images.size) { index ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(if (pagerState.currentPage == index) 18.dp else 12.dp)
                                .background(
                                    if (pagerState.currentPage == index) Color.White else Color.Gray,
                                    shape = RoundedCornerShape(50)
                                )
                        )
                    }
                }
            }

            // SECCIÓN DE DETALLES
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1E1E1E))
                    .padding(20.dp)
            ) {
                Text("SKIRTS", color = Color.Gray, fontSize = 16.sp)

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(shirt.name, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    Text(shirt.price, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 26.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {
                    Text("Size:", color = Color.White, fontSize = 20.sp)
                    listOf("S", "M", "L", "XL").forEach { size ->
                        Text(
                            text = size,
                            color = if (selectedSize == size) Color(0xFF4285F4) else Color.White,
                            fontWeight = if (selectedSize == size) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = onAddToBag,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4285F4)),
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Add to Bag", color = Color.White)
                }
            }
        }

        // BOTONES SUPERIORES
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.background(Color.Black.copy(alpha = 0.3f), RoundedCornerShape(50))
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
            }

            IconButton(
                onClick = onFavoriteClick,
                modifier = Modifier.background(Color.Black.copy(alpha = 0.3f), RoundedCornerShape(50))
            ) {
                Icon(Icons.Filled.FavoriteBorder, contentDescription = "Favorite", tint = Color.White)
            }
        }
    }
}
