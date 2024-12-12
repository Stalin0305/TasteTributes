package com.example.tastetributes.features.onboarding.di

import com.example.tastetributes.database.dao.UserDao
import com.example.tastetributes.datastore.DataStoreHelper
import com.example.tastetributes.features.onboarding.data.repository.local.LoginRepositoryImpl
import com.example.tastetributes.features.onboarding.domain.repository.LoginRepository
import com.example.tastetributes.features.onboarding.domain.services.AuthenticationService
import com.example.tastetributes.features.onboarding.domain.services.AuthenticationServiceImpl
import com.example.tastetributes.features.onboarding.domain.usecases.CreateAccountUseCase
import com.example.tastetributes.utils.FirebaseAuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object OnboardingModule {

    @Provides
    fun providesAuthenticationService(firebaseAuthService: FirebaseAuthService): AuthenticationService {
        return AuthenticationServiceImpl(firebaseAuthService)
    }

    @Provides
    fun provideLoginRepository(
        authenticationService: AuthenticationService, userDao: UserDao,
        dataStoreHelper: DataStoreHelper,
    ): LoginRepository {
        return LoginRepositoryImpl(
            authenticationService,
            userDao,
            dataStoreHelper
        )
    }

    @Provides
    fun provideCreateAccountUseCase(loginRepository: LoginRepository): CreateAccountUseCase {
        return CreateAccountUseCase(
            loginRepository
        )
    }
}