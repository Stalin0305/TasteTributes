package com.example.tastetributes.features.onboarding.data.mappers

import com.example.tastetributes.features.onboarding.data.models.UserResponseModel
import com.example.tastetributes.features.onboarding.domain.models.UserDataModel

fun UserResponseModel.toDomain(): UserDataModel {
    return UserDataModel(
        userName, email, token, uuid, status
    )
}