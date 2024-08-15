package com.example.tastetributes.features.onboarding.ui.viewstates.login

import com.example.tastetributes.foundation.NavEffect
import com.example.tastetributes.foundation.UserIntent
import com.example.tastetributes.foundation.ViewState
import com.example.tastetributes.utils.Constants.EMPTY_STRING

data class ViewState(val loginViewState: LoginViewState): ViewState

sealed class LoginViewState: ViewState {
    data object UnInitialized: LoginViewState()

    data object Loading: LoginViewState()

    data class LoadedData(
        val email: String = EMPTY_STRING,
        val password: String = EMPTY_STRING,
        val isSignInButtonEnabled: Boolean = false,
        val isEmailInvalid: Boolean = false,
    ): LoginViewState()
}

sealed interface LoginIntent: UserIntent {
    data object HandleSignInInButtonIntent: LoginIntent

    data class HandleEmailValueChange(
        val email: String,
    ): LoginIntent

    data object LoadData: LoginIntent

    data object HandleSignUpClicked: LoginIntent

    data class HandlePasswordChangeIntent(
        val password: String,
    ): LoginIntent

    data object HandleForgotPasswordIntent: LoginIntent
}


sealed interface LoginEffect: NavEffect {
    data object NavigateBack: LoginEffect

    data object NavigateToHomeScreen: LoginEffect

    data object NavigateToRegistrationScreen: LoginEffect
}