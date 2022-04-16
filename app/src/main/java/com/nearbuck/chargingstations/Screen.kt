package com.nearbuck.chargingstations

sealed class Screen(val route: String) {
    object Home: Screen(route = "home")
    object CityView: Screen(route = "city/{cityData}")
}