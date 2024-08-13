package com.example.tastetributes.features.onboarding.data.repository.local

import com.example.tastetributes.database.dao.UserDao
import com.example.tastetributes.database.entities.UserInfo
import com.example.tastetributes.features.onboarding.domain.models.UserDataModel
import com.example.tastetributes.features.onboarding.domain.repository.LoginRepository
import com.example.tastetributes.features.onboarding.domain.services.AuthenticationService
import com.example.tastetributes.utils.Status
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val authenticationService: AuthenticationService,
    private val userDao: UserDao,
) : LoginRepository {
    override suspend fun loginWithEmailAndPassword(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun loginWithGoogleSignIn() {
        TODO("Not yet implemented")
    }

    override suspend fun createNewUserWithEmailAndPassword(
        email: String,
        password: String,
    ): Flow<Boolean> {
        return flow {
            authenticationService.createNewAccount(email, password).collect {
                when (it.status) {
                    Status.Success -> {
                        emitCreateUserSuccess(it.data)
                    }

                    Status.Error -> {
                        emit(false)
                    }

                    else -> {
                        emit(false)
                    }
                }

            }
        }
    }

    private fun emitCreateUserSuccess(userDataModel: UserDataModel?): Flow<Boolean> {
        return flow{
            getUserInfo(userDataModel)?.let {
                userDao.addUser(it)
                emit(true)
            } ?: emit(false)

        }
    }

    private fun getUserInfo(userDataModel: UserDataModel?): UserInfo? {
        return userDataModel?.let {
            UserInfo(
                email = it.email,
                userName = it.userName,
                uuid = it.uuid,
            )
        }
    }
}