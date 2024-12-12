package com.example.tastetributes.features.onboarding.data.repository.local

import com.example.tastetributes.database.dao.UserDao
import com.example.tastetributes.database.entities.UserInfo
import com.example.tastetributes.datastore.DataStoreHelper
import com.example.tastetributes.features.onboarding.data.mappers.toDomain
import com.example.tastetributes.features.onboarding.data.models.UserResponseModel
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
    private val dataStoreHelper: DataStoreHelper,
) : LoginRepository {
    override suspend fun loginWithEmailAndPassword(
        email: String,
        password: String,
    ): Flow<UserData?> {
        return flow {
            emit(UserData(status = Status.Loading, data = null))
            authenticationService.login(email, password).collect { result ->
                if (result.isSuccess) {
                    emitCreateUserSuccess(result.getOrNull()).collect { data ->
                        getUserInfo(data)?.let {
                            userDao.addUser(it)
                        }
                        dataStoreHelper.saveToDataStore(DataStoreHelper.IS_LOGGED_IN, true)
                        emit(UserData(data = data, status = Status.Success))
                    }
                } else {
                    emit(
                        UserData(
                            data = null,
                            error = result.exceptionOrNull()?.message ?: "Something went wrong",
                            status = Status.Error
                        )
                    )
                }
            }
        }
    }

    override suspend fun loginWithGoogleSignIn() {
        TODO("Not yet implemented")
    }

    override suspend fun createNewUserWithEmailAndPassword(
        email: String,
        password: String,
    ): Flow<UserData?> {
        return flow {
            emit(UserData(status = Status.Loading, data = null))
            authenticationService.createNewAccount(email, password).collect { result ->
                if (result.isSuccess) {
                    emitCreateUserSuccess(result.getOrNull()).collect { data ->
                        getUserInfo(data)?.let {
                            userDao.addUser(it)
                        }
                        dataStoreHelper.saveToDataStore(DataStoreHelper.IS_LOGGED_IN, true)
                        emit(UserData(data = data, status = Status.Success))
                    }
                } else {
                    emit(
                        UserData(
                            data = null,
                            error = result.exceptionOrNull()?.message ?: "Something went wrong",
                            status = Status.Error
                        )
                    )
                }
            }
        }
    }

    private fun emitCreateUserSuccess(userDataModel: UserResponseModel?): Flow<UserDataModel?> {
        return flow {
            emit(userDataModel?.toDomain())
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

