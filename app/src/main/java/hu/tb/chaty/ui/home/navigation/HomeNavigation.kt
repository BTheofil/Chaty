package hu.tb.chaty.ui.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import hu.tb.chaty.ui.home.HomeScreen
import hu.tb.chaty.ui.navigation.Routes

const val homeScreenRoute = "home_route"

fun NavController.navigateToHome() {
    this.navigate(homeScreenRoute)
}

fun NavGraphBuilder.homeScreenRoute(navigateTo: (Routes) -> Unit) {
    composable(route = homeScreenRoute) {
        HomeScreen(navigateTo)
    }
}

