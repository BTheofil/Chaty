package hu.tb.chaty.ui.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import hu.tb.chaty.ui.main.MainScreen
import hu.tb.chaty.ui.navigation.Routes

const val mainScreenRoute = "main_route"

fun NavController.navigateToMain() {
    this.navigate(mainScreenRoute)
}

fun NavGraphBuilder.mainScreenRoute(navigateTo: (Routes) -> Unit) {
    composable(route = mainScreenRoute) {
        MainScreen(navigateTo)
    }
}