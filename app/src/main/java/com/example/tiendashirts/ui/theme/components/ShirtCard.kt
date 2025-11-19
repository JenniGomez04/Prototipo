// Dibuja cada tarjeta de una camisa.
package com.example.tiendashirts.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tiendashirts.data.Shirt

@Composable
fun ShirtCard(
    shirt: Shirt,
    onClick: (Int) -> Unit,
    onFavoriteClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(shirt.id) }
    ) {
        Box {
            Image(
                painter = painterResource(id = shirt.images.first()),
                contentDescription = shirt.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            // Corazón en esquina inferior derecha
            IconButton(
                onClick = { onFavoriteClick(shirt.id) },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = if (shirt.isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Favorito",
                    tint = if (shirt.isFavorite) Color.Red else Color.White
                )
            }
        }

        Column {
            Text(text = shirt.name, modifier = Modifier.padding(8.dp))
            Text(text = shirt.price, modifier = Modifier.padding(start = 8.dp, bottom = 8.dp))
        }
    }
}
