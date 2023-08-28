package hu.tb.chaty.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.tb.chaty.domain.usecase.AppRealmUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val appRealm: AppRealmUseCase
) : ViewModel() {

    data class LoginState(
        var email: String = "",
        var password: String = "",
    )

    sealed class LoginEvent {
        object OnLoginClick : LoginEvent()
        data class OnEmailChange(val text: String) : LoginEvent()
        data class OnPasswordChange(val text: String) : LoginEvent()
    }

    sealed class LoginNews {
        object NavigateToHome : LoginNews()
    }

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    private val _news = Channel<LoginNews>()
    val news = _news.receiveAsFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnEmailChange -> _state.update { it.copy(email = event.text) }
            is LoginEvent.OnPasswordChange -> _state.update { it.copy(password = event.text) }

            LoginEvent.OnLoginClick -> {
                viewModelScope.launch {
                    try {
                        appRealm.loginUser(state.value.email, state.value.password)
                        _news.send(LoginNews.NavigateToHome)
                    } catch (e: Exception){
                        Log.e("LoginViewModel", e.message ?: "Can not log in user")
                    }
                }
            }
        }
    }
}