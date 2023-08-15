package hu.tb.chaty.domain.usecase

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        val result = ValidatorUseCase().emailCheck("name@email.com")
        assertTrue(result.successful)
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        val result = ValidatorUseCase().emailCheck("")
        assertFalse(result.successful)
    }

    @Test
    fun emailValidator_NotValidEmail_ReturnsFalse() {
        val result = ValidatorUseCase().emailCheck("hello")
        assertFalse(result.successful)
    }

    @Test
    fun passwordValidator_CorrectPassword_ReturnsTrue() {
        val result = ValidatorUseCase().passwordCheck("A12345")
        assertTrue(result.successful)
    }

    @Test
    fun passwordValidator_ShortPassword_ReturnsFalse() {
        val result = ValidatorUseCase().passwordCheck("B123")
        assertFalse(result.successful)
    }

    @Test
    fun passwordValidator_NoLetterPassword_ReturnsTrue() {
        val result = ValidatorUseCase().passwordCheck("123456")
        assertFalse(result.successful)
    }

    @Test
    fun passwordValidator_NoDigitPassword_ReturnsTrue() {
        val result = ValidatorUseCase().passwordCheck("Abcdef")
        assertFalse(result.successful)
    }
}