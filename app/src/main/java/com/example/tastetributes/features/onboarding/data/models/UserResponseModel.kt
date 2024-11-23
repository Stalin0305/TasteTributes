package com.example.tastetributes.features.onboarding.data.models

import com.example.tastetributes.utils.Status

data class UserResponseModel(
    val userName: String,
    val email: String,
    val token: String,
    val uuid: String,
    val status: Status,
)
