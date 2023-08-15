package hu.tb.chaty.domain.usecase

import android.util.Patterns

class ValidatorUseCase {

    fun emailCheck(email: String): ValidationResult {
        if(email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "The email can't be blank"
            )
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "That's not a valid email"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

    fun passwordCheck(password: String): ValidationResult {
        if(password.length < 5) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password needs to consist of at least 6 characters"
            )
        }
        val containsLettersAndDigits = password.any { it.isDigit() } &&
                password.any { it.isLetter() }
        if(!containsLettersAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password needs to contain at least one letter and digit"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

    data class ValidationResult(
        val successful: Boolean,
        val errorMessage: String? = null
    )
}