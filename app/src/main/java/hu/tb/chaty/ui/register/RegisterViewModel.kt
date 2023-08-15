package hu.tb.chaty.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.tb.chaty.domain.usecase.ValidatorUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val validator: ValidatorUseCase = ValidatorUseCase()
): ViewModel(){

    data class RegisterState(
        val email: String = "",
        val isEmailValid: Boolean = true,
        val password: String = "",
        val isPasswordValid: Boolean = true,
    )

    sealed class RegisterEvent{
        data object OnRegisterClick: RegisterEvent()
        data class OnEmailChange(val text: String): RegisterEvent()
        data class OnPasswordChange(val text: String): RegisterEvent()
    }

    sealed class RegisterNews{
        data object NavigateToHome: RegisterNews()
    }

    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()

    private val _news = Channel<RegisterNews>()
    val news = _news.receiveAsFlow()

    fun onEvent(event: RegisterEvent){
        when(event){
            is RegisterEvent.OnEmailChange -> _state.value = _state.value.copy(email = event.text)
            is RegisterEvent.OnPasswordChange -> _state.value = _state.value.copy(password = event.text)
            RegisterEvent.OnRegisterClick -> {
                val emailResult = validator.emailCheck(state.value.email)
                val passwordResult  = validator.passwordCheck(state.value.password)

                val hasError = listOf(
                    emailResult,
                    passwordResult,
                ).any { !it.successful }

                if(hasError) {
                    _state.value = _state.value.copy(
                        isEmailValid = emailResult.successful,
                        isPasswordValid = passwordResult.successful,
                    )
                    return
                }

                viewModelScope.launch {
                    _news.send(RegisterNews.NavigateToHome)
                }
            }
        }
    }
}