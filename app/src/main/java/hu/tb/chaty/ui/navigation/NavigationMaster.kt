package hu.tb.chaty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import hu.tb.chaty.ui.home.navigation.homeScreenRoute
import hu.tb.chaty.ui.home.navigation.navigateToHome
import hu.tb.chaty.ui.login.navigation.loginScreenRoute
import hu.tb.chaty.ui.login.navigation.navigateToLogin
import hu.tb.chaty.ui.main.navigation.mainScreenRoute
import hu.tb.chaty.ui.main.navigation.navigateToMain
import hu.tb.chaty.ui.register.navigation.navigateToRegister
import hu.tb.chaty.ui.register.navigation.registerScreenRoute

@Composable
fun NavigationMaster() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = mainScreenRoute) {
        mainScreenRoute(
            navigateTo = { navController.handleNavigation(it) })
        registerScreenRoute(
            navigateTo = { navController.handleNavigation(it) })
        loginScreenRoute(
            navigateTo = { navController.handleNavigation(it) }
        )
        homeScreenRoute(
            navigateTo = { navController.handleNavigation(it) }
        )
    }
}

fun NavController.handleNavigation(route: Routes) {
    when (route) {
        Routes.MAIN -> navigateToMain()
        Routes.REGISTER -> navigateToRegister()
        Routes.LOGIN -> navigateToLogin()
        Routes.HOME -> navigateToHome()
    }
}