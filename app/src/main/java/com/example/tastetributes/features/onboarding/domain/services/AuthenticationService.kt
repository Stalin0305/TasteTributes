package com.example.tastetributes.features.onboarding.domain.services

import com.example.tastetributes.features.onboarding.data.models.UserResponseModel
import com.example.tastetributes.features.onboarding.domain.models.UserDataModel
import com.example.tastetributes.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthenticationService {
    suspend fun login(email:String, password:String): Flow<Result<UserResponseModel>>

    suspend fun createNewAccount(email: String, password: String): Flow<Result<UserResponseModel>>
}