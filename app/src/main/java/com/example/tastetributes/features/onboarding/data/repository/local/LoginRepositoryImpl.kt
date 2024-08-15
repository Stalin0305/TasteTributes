package com.example.tastetributes.features.onboarding.data.repository.local

import com.example.tastetributes.database.dao.UserDao
import com.example.tastetributes.database.entities.UserInfo
import com.example.tastetributes.features.onboarding.domain.models.UserData
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
    ): Flow<UserData?> {
        return flow {
            authenticationService.createNewAccount(email, password).collect {
                when (it.status) {
                    Status.Success -> {
                        emitCreateUserSuccess(it.data).collect {data ->
                            emit(UserData(data = data, status = Status.Success))
                        }
                    }

                    Status.Error -> {
                        emit(
                            UserData(
                                data = null,
                                error = it.message ?: "Something went wrong",
                                status = Status.Error
                            )
                        )
                    }
                }
            }
        }
    }

    private fun emitCreateUserSuccess(userDataModel: UserDataModel?): Flow<UserDataModel?> {
        return flow{
            getUserInfo(userDataModel)?.let {
                userDao.addUser(it)
                emit(userDataModel)
            } ?: emit(userDataModel)

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