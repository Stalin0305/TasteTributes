package com.example.tastetributes.features.onboarding.domain.models

import com.example.tastetributes.utils.Constants.EMPTY_STRING
import com.example.tastetributes.utils.Status

data class UserDataModel(
    val userName: String,
    val email: String,
    val token: String,
    val uuid: String,
    val status: Status,
) {
    fun emptyValue() = UserDataModel(
        userName = EMPTY_STRING,
        email = EMPTY_STRING,
        token = EMPTY_STRING,
        uuid = EMPTY_STRING,
        status = Status.Success
    )
}

data class UserData(val status: Status, val data: UserDataModel?, val error: String = EMPTY_STRING)
