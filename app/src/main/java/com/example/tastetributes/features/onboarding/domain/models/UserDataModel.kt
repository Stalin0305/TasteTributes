package com.example.tastetributes.features.onboarding.domain.models

import com.example.tastetributes.utils.Constants.EMPTY_STRING

data class UserDataModel(
    val userName: String,
    val email: String,
    val token: String,
    val uuid: String,
) {
    fun emptyValue() = UserDataModel(
        userName = EMPTY_STRING,
        email = EMPTY_STRING,
        token = EMPTY_STRING,
        uuid = EMPTY_STRING,
    )
}
