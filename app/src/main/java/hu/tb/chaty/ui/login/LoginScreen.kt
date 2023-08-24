package hu.tb.chaty.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import hu.tb.chaty.ui.navigation.Routes

@Composable
fun LoginScreen(navigateTo: (Routes) -> Unit) {

    LoginScreenContent()
}

@Composable
private fun LoginScreenContent(){
    Column {
        //TODO
    }
}

@Preview
@Composable
fun LoginScreenContentPreview() {
    LoginScreenContent()
}