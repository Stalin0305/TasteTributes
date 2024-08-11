package com.example.tastetributes.onboarding.domain.repository

import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun loginWithEmailAndPassword(email: String, password: String)

    suspend fun loginWithGoogleSignIn()

    suspend fun createNewUserWithEmailAndPassword(email: String, password: String): Flow<Boolean>
}