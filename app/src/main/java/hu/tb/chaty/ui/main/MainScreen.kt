package hu.tb.chaty.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import hu.tb.chaty.ui.navigation.Routes

@Composable
fun MainScreen(
    navigateTo: (Routes) -> Unit,
    vm: MainViewModel = hiltViewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            navigateTo(Routes.REGISTER)
        }) {
            Text(text = "Register new user")
        }
        Button(onClick = {

        }) {
            Text(text = "Log in")
        }
    }
}