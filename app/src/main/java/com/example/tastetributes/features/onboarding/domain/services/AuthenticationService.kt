package com.example.tastetributes.features.onboarding.domain.services

import com.example.tastetributes.features.onboarding.domain.models.UserDataModel
import com.example.tastetributes.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthenticationService {
    suspend fun login(email:String, password:String)

    suspend fun createNewAccount(email: String, password: String): Flow<Resource<UserDataModel>>
}