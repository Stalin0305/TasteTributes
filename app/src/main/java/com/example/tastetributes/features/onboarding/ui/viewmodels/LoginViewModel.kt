package com.example.tastetributes.features.onboarding.ui.viewmodels

import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginEffect
import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginIntent
import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginViewState
import com.example.tastetributes.features.onboarding.ui.viewstates.login.ViewState
import com.example.tastetributes.foundation.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

): MviViewModel<LoginIntent, ViewState, LoginEffect>() {
    override fun createInitialState(): ViewState {
        return ViewState(LoginViewState.Loading)
    }

    override fun handleIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.Login -> {}
            is LoginIntent.HandleEmailValueChange -> {
                val currentState = currentState.loginViewState as LoginViewState.LoadedData
                emitViewState {
                   copy(
                       loginViewState = currentState.copy(email = intent.email)
                   )

                }
            }
            is LoginIntent.LoadData -> {
                emitViewState {
                    copy(loginViewState = LoginViewState.LoadedData("",""))
                }
            }

            is LoginIntent.HandleSignUpClicked -> {
                sendNavEffect(LoginEffect.NavigateToRegistrationScreen)
            }
        }
    }



}