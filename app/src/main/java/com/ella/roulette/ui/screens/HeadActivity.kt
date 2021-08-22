package com.ella.roulette.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ella.roulette.ui.entities.Beverage
import com.ella.roulette.ui.entities.Helper
import com.ella.roulette.ui.theme.AlcorouletteTheme
import com.ella.roulette.ui.ui.BeverageList

@ExperimentalFoundationApi
class HeadActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen {
                ScreenContent()
            }
        }
    }
}

@Composable
fun AppScreen(content: @Composable () -> Unit) {
    AlcorouletteTheme() {
        content()
    }
}

@ExperimentalFoundationApi
@Composable
fun ScreenContent() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "allBeverages") {
        composable("allBeverages") {
            AllBeverages(
                navController = navController,
                beverages = Helper.beverages
            )
        }

        composable("sosi") { SosiHuy(navController = navController) }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppScreen {
        ScreenContent()
    }
}

@ExperimentalFoundationApi
@Composable
fun AllBeverages(navController: NavController, beverages: ArrayList<Beverage>) {
    BeverageList(beverages = beverages)
    Text(
        text = "Sam Sosi",
        modifier = Modifier.clickable {
            navController.navigate("sosi")
        })
}

@Composable
fun SosiHuy(navController: NavController) {
    Text(
        text = "Sosi Xuy",
        modifier = Modifier.clickable {
            navController.navigate("allBeverages")
        })
}