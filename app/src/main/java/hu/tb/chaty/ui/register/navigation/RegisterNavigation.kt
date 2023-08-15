package hu.tb.chaty.ui.register.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import hu.tb.chaty.ui.navigation.Routes
import hu.tb.chaty.ui.register.RegisterScreen

const val registerScreenRoute = "register_route"

fun NavController.navigateToRegister() {
    this.navigate(registerScreenRoute)
}

fun NavGraphBuilder.registerScreenRoute(navigateTo: (Routes) -> Unit) {
    composable(route = registerScreenRoute) {
        RegisterScreen(navigateTo = navigateTo)
    }
}