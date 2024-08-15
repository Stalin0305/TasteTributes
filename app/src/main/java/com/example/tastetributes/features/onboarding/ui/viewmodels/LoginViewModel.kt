package com.example.tastetributes.features.onboarding.ui.viewmodels

import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginEffect
import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginIntent
import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginViewState
import com.example.tastetributes.features.onboarding.ui.viewstates.login.ViewState
import com.example.tastetributes.foundation.MviViewModel
import com.example.tastetributes.utils.isEmailValid
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : MviViewModel<LoginIntent, ViewState, LoginEffect>() {
    override fun createInitialState(): ViewState {
        return ViewState(LoginViewState.Loading)
    }

    override fun handleIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.HandleSignInInButtonIntent -> {}
            is LoginIntent.HandleEmailValueChange -> {
                val currentState = currentState.loginViewState as LoginViewState.LoadedData
                emitViewState {
                    copy(
                        loginViewState = currentState.copy(
                            email = intent.email,
                            isEmailInvalid = intent.email.isEmailValid().not()
                        ),
                    )
                }
                checkIfSignInButtonEnabled()
            }

            is LoginIntent.LoadData -> {
                emitViewState {
                    copy(loginViewState = LoginViewState.LoadedData("", ""))
                }
            }

            is LoginIntent.HandleSignUpClicked -> {
                sendNavEffect(LoginEffect.NavigateToRegistrationScreen)
            }

            LoginIntent.HandleForgotPasswordIntent -> {}
            is LoginIntent.HandlePasswordChangeIntent -> {
                val currentState = currentState.loginViewState as LoginViewState.LoadedData
                emitViewState {
                    copy(
                        loginViewState = currentState.copy(
                            password = intent.password,
                            isEmailInvalid = currentState.email.isEmailValid().not()
                        ),
                    )
                }
                checkIfSignInButtonEnabled()
            }
        }
    }

    private fun isSignInButtonEnabled(): Boolean {
        val currentState = currentState.loginViewState as LoginViewState.LoadedData
        return currentState.isEmailInvalid.not() && currentState.password.isNotBlank()
    }

    private fun checkIfSignInButtonEnabled() {
        val currentState = currentState.loginViewState as LoginViewState.LoadedData
        emitViewState {
            copy(
                loginViewState = currentState.copy(
                    isSignInButtonEnabled = isSignInButtonEnabled()
                )
            )
        }
    }


}