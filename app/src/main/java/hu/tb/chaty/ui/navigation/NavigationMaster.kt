package hu.tb.chaty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import hu.tb.chaty.ui.main.navigation.mainScreenRoute
import hu.tb.chaty.ui.register.navigation.navigateToRegister
import hu.tb.chaty.ui.register.navigation.registerScreenRoute

@Composable
fun NavigationMaster() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = mainScreenRoute) {
        mainScreenRoute(
            navigateTo = { navController.handleNavigation(it) })
        registerScreenRoute()
    }
}

fun NavController.handleNavigation(route: Routes) {
    when (route) {
        Routes.MAIN -> TODO()
        Routes.REGISTER -> navigateToRegister()
    }
}