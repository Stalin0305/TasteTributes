package com.example.tastetributes.features.login.ui.viewstates

import com.example.tastetributes.foundation.NavEffect
import com.example.tastetributes.foundation.UserIntent
import com.example.tastetributes.foundation.ViewState

data class ViewState(val loginViewState: LoginViewState): ViewState

sealed class LoginViewState: ViewState {
    data object UnInitialized: LoginViewState()

    data object Loading: LoginViewState()

    data class LoadedData(
        val email: String,
        val password: String,
    ): LoginViewState()
}

sealed interface LoginIntent: UserIntent {
    data object Login: LoginIntent

    data class HandleEmailValueChange(
        val email: String,
    ): LoginIntent

    data object LoadData: LoginIntent
}


sealed interface LoginEffect: NavEffect {
    object NavigateBack: LoginEffect

    object NavigateToHomeScreen: LoginEffect
}