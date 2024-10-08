package com.example.tastetributes.utils

import android.content.Context
import com.example.tastetributes.onboarding.domain.models.UserDataModel
import com.example.tastetributes.utils.Constants.EMPTY_STRING
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthService @Inject constructor(
    @ApplicationContext private val context: Context
) {
    @Inject lateinit var auth: FirebaseAuth

    suspend fun createNewUser(email: String, password: String): Flow<Resource<UserDataModel>> {
        return flow {
            if (NetworkHelper.isConnectedToNetwork(context)) {
                val result = auth.createUserWithEmailAndPassword(email, password).await()
                val authUser = result.user
                if (authUser != null) {
                    val token = authUser.getIdToken(false).await()?.token
                    val userInfo = UserDataModel(
                        email = authUser.email ?: EMPTY_STRING,
                        userName = authUser.displayName ?: EMPTY_STRING,
                        token = token ?: EMPTY_STRING,
                        uuid = authUser.uid
                    )
                    emit(Resource.Success(data = userInfo))
                } else {
                    emit(Resource.Error(message = "Failed to create account"))
                }
            } else {
                emit(Resource.Error(message = "Please check your internet connection"))
            }
        }
    }

}