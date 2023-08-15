package hu.tb.chaty.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import kotlinx.coroutines.runBlocking

class MainViewModel: ViewModel() {

    fun registerUser(){
        val app = App.create("chaty-apsyk")
        runBlocking {
            //app.emailPasswordAuth.registerUser("asd@asd.hu", "123456")
            //app.emailPasswordAuth.registerUser("test@test.hu", "123456")

            //app.login(Credentials.emailPassword("test@test.hu", "123456"))
            //app.login(Credentials.emailPassword("asd@asd.hu", "123456"))
            //app.emailPasswordAuth.retryCustomConfirmation("asd@asd.hu")
            Log.d("MYTAG", app.currentUser!!.accessToken)
        }

    }
}