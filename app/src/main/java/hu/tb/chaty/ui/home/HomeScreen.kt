package hu.tb.chaty.ui.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import hu.tb.chaty.ui.navigation.Routes

@Composable
fun HomeScreen(navigateTo: (Routes) -> Unit) {
    Text(text = "login nice")
}