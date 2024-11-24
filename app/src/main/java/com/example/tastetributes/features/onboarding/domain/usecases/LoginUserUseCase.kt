package com.example.tastetributes.features.onboarding.domain.usecases

import com.example.tastetributes.features.onboarding.domain.models.UserData
import com.example.tastetributes.features.onboarding.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {
    suspend operator fun invoke(email: String, password: String): Flow<UserData?> {
        return loginRepository.loginWithEmailAndPassword(email, password)
    }
}