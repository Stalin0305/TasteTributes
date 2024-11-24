package com.example.tastetributes.features.onboarding.domain.repository

import com.example.tastetributes.features.onboarding.domain.models.UserData
import com.example.tastetributes.features.onboarding.domain.models.UserDataModel
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun loginWithEmailAndPassword(email: String, password: String): Flow<UserData?>

    suspend fun loginWithGoogleSignIn()

    suspend fun createNewUserWithEmailAndPassword(email: String, password: String): Flow<UserData?>
}