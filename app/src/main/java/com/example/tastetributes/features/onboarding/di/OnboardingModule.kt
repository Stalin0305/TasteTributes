package com.example.tastetributes.features.onboarding.di

import com.example.tastetributes.features.onboarding.domain.services.AuthenticationService
import com.example.tastetributes.features.onboarding.domain.services.AuthenticationServiceImpl
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
}