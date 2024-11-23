package com.example.tastetributes.features.onboarding.domain.services

import com.example.tastetributes.features.onboarding.data.models.UserResponseModel
import com.example.tastetributes.features.onboarding.domain.models.UserDataModel
import com.example.tastetributes.utils.FirebaseAuthService
import com.example.tastetributes.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthenticationServiceImpl @Inject constructor(
    private val firebaseAuthService: FirebaseAuthService
): AuthenticationService {
    override suspend fun login(email: String, password: String): Flow<Result<UserResponseModel>> {
        return firebaseAuthService.login(email, password)
    }

    override suspend fun createNewAccount(email: String, password: String): Flow<Result<UserResponseModel>> {
        return firebaseAuthService.createNewUser(email, password)
    }
}