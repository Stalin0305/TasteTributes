package com.example.tastetributes.features.onboarding.domain.usecases

import com.example.tastetributes.features.onboarding.data.models.CreateUserRequest
import com.example.tastetributes.features.onboarding.domain.models.UserData
import com.example.tastetributes.features.onboarding.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateAccountUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) {
    suspend operator fun invoke(createUserDataModel: CreateUserRequest): Flow<UserData?> {
        return loginRepository.createNewUserWithEmailAndPassword(
            createUserDataModel.email,
            createUserDataModel.password
        )

    }
}