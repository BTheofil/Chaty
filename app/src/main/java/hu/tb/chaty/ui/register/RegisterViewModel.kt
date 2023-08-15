package hu.tb.chaty.ui.register

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel: ViewModel(){

    data class RegisterState(
        val email: String = "",
        val password: String = ""
    )

    sealed class RegisterEvent{
        data class OnEmailChange(val text: String): RegisterEvent()
    }

    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()

    fun onEvent(event: RegisterEvent){
        when(event){
            is RegisterEvent.OnEmailChange -> _state.value = _state.value.copy(email = event.text)
        }
    }
}