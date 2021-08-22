package com.ella.roulette.ui.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import com.ella.roulette.ui.entities.Beverage

@ExperimentalFoundationApi
@Composable
fun BeverageList(beverages: ArrayList<Beverage>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
    ) {
        item {
            AddCard()
        }
        items(beverages.size) { index ->
            BeverageCard(beverages[index])
        }
    }
}