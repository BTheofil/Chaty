package hu.tb.chaty.domain.usecase

import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import java.io.Serializable
import javax.inject.Inject

class AppRealmUseCase @Inject constructor(
    private val app: App
) {

    suspend fun registerNewUser(email: String, password: String){
        try {
            app.emailPasswordAuth.registerUser(email, password)
        } catch (e: Exception){
            throw AppRealmException(e.message?: "Error happened when register")
        }
    }

    suspend fun loginUser(email: String, password: String){
        try {
            app.login(Credentials.emailPassword(email, password))
        } catch (e: Exception){
            throw AppRealmException(e.message?: "Error happened when login")
        }
    }
}

class AppRealmException(message: Serializable) : Exception(message.toString())