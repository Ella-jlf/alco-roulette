package com.ella.roulette.ui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ella.roulette.R
import com.ella.roulette.ui.entities.Beverage
import com.ella.roulette.ui.utils.loadPictureWithGlide

@Composable
fun BeverageCard(item: Beverage) {
    Surface(
        modifier = Modifier
            .size(120.dp, 180.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(24.dp))
            .clickable(onClick = { /* Ignoring onClick */ }),
        color = Color(0xFF00FFFF),
        shape = RectangleShape
    ) {
        Box(contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    modifier = Modifier.size(88.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
                ) {
                    val image = loadPictureWithGlide(
                        uri = item.pictureUri,
                        defaultImage = R.drawable.icon_beverage_default
                    )
                    image.value?.let { beverageImage ->
                        Image(
                            bitmap = beverageImage.asImageBitmap(),
                            contentDescription = null
                        )
                    }
                }
                Text(
                    text = item.name ?: "Not indicated",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(0.dp, 16.dp)
                )
            }
        }
    }
}

@Composable
fun AddCard() {
    Surface(
        modifier = Modifier
            .size(120.dp, 180.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(24.dp))
            .clickable(onClick = { /* Ignoring onClick */ }),
        color = Color(0xFF808080),
        shape = RectangleShape,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Surface(
                modifier = Modifier
                    .size(72.dp, 120.dp)
                    .clip(RoundedCornerShape(24.dp)),
                shape = RectangleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_add),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}