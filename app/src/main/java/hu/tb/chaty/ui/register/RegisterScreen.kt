package hu.tb.chaty.ui.register

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    vm: RegisterViewModel = hiltViewModel()
) {
    val state by vm.state.collectAsState()

    Column {
        TextField(
            value = state.email,
            onValueChange = {
                vm.onEvent(RegisterViewModel.RegisterEvent.OnEmailChange(it))
            }
        )
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}