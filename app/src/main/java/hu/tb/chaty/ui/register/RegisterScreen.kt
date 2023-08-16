package hu.tb.chaty.ui.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import hu.tb.chaty.R
import hu.tb.chaty.common.CustomAlertDialog
import hu.tb.chaty.ui.navigation.Routes

@Composable
fun RegisterScreen(
    vm: RegisterViewModel = hiltViewModel(),
    navigateTo: (Routes) -> Unit
) {
    val state by vm.state.collectAsState()

    var openDialog by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = LocalContext.current) {
        vm.news.collect { news ->
            when (news) {
                is RegisterViewModel.RegisterNews.NavigateToHome -> navigateTo(Routes.HOME)
                RegisterViewModel.RegisterNews.ExceptionHappened -> {
                    openDialog = true
                }
            }
        }
    }


    if (openDialog) {
        CustomAlertDialog(
            title = "Error happened",
            text = "Can not create user",
            buttonTitle = "Okay",
            confirmButton = { openDialog = false },
            onDismissListener = { openDialog = false }
        )
    }

    RegisterScreenContent(
        state,
        onEmailChange = { vm.onEvent(RegisterViewModel.RegisterEvent.OnEmailChange(it)) },
        onPasswordChange = { vm.onEvent(RegisterViewModel.RegisterEvent.OnPasswordChange(it)) },
        onRegisterButtonChange = { vm.onEvent(RegisterViewModel.RegisterEvent.OnRegisterClick) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegisterScreenContent(
    state: RegisterViewModel.RegisterState,
    onEmailChange: (text: String) -> Unit,
    onPasswordChange: (text: String) -> Unit,
    onRegisterButtonChange: () -> Unit
) {
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    Column {
        OutlinedTextField(
            value = state.email,
            onValueChange = onEmailChange,
            label = { Text("Email") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            isError = !state.isEmailValid
        )
        OutlinedTextField(
            value = state.password,
            onValueChange = onPasswordChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        painter = painterResource(
                            if (isPasswordVisible)
                                R.drawable.outline_visibility_24
                            else
                                R.drawable.outline_visibility_off_24
                        ),
                        contentDescription = "toggle password visibility"
                    )
                }
            },
            label = { Text("Password") },
            maxLines = 1,
            isError = !state.isPasswordValid
        )
        OutlinedButton(onClick = onRegisterButtonChange) {
            Text(text = "Register")
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreenContent(RegisterViewModel.RegisterState(), {}, {}, {})
}