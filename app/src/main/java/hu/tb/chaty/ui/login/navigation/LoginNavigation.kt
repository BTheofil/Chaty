package hu.tb.chaty.ui.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import hu.tb.chaty.ui.login.LoginScreen
import hu.tb.chaty.ui.navigation.Routes

const val loginScreenRoute = "login_route"

fun NavController.navigateToLogin() {
    this.navigate(loginScreenRoute)
}

fun NavGraphBuilder.loginScreenRoute(navigateTo: (Routes) -> Unit) {
    composable(route = loginScreenRoute) {
        LoginScreen(navigateTo = navigateTo)
    }
}