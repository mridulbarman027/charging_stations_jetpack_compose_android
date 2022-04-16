package com.nearbuck.chargingstations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetUpNavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeView(navController)
        }
        composable(
            route = Screen.CityView.route,
            arguments = listOf(navArgument("cityData") {
                type = NavType.StringType
            })
        ) {
            val cityData: String =  it.arguments?.getString("cityData").toString()
            CityView(navController, cityData)
        }
    }
}