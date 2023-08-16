package hu.tb.chaty.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.tb.chaty.domain.usecase.ValidatorUseCase
import io.realm.kotlin.mongodb.App
import javax.inject.Singleton

private const val API_REALM = "chaty-apsyk"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideValidator(): ValidatorUseCase = ValidatorUseCase()

    @Provides
    @Singleton
    fun provideAppRealm(): App = App.create(API_REALM)
}