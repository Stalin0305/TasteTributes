package com.example.tastetributes.features.onboarding.ui.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.tastetributes.features.onboarding.domain.usecases.LoginUserUseCase
import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginEffect
import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginIntent
import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginViewState
import com.example.tastetributes.features.onboarding.ui.viewstates.login.ViewState
import com.example.tastetributes.foundation.MviViewModel
import com.example.tastetributes.utils.Status
import com.example.tastetributes.utils.isEmailValid
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUserUseCase: LoginUserUseCase,
) : MviViewModel<LoginIntent, ViewState, LoginEffect>() {
    override fun createInitialState(): ViewState {
        return ViewState(LoginViewState.Loading)
    }

    override fun handleIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.HandleSignInInButtonIntent -> {
                val currentState = currentState.loginViewState as LoginViewState.LoadedData
                val email = currentState.email
                val password = currentState.password
                loginUser(email, password)
            }
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

    private fun loginUser(email: String, password: String) {
        val currentState = currentState.loginViewState as LoginViewState.LoadedData
        viewModelScope.launch {
            loginUserUseCase.invoke(email, password).collect { userData ->
                when (userData?.status) {
                    Status.Success -> {
                        emitViewState {
                            this.copy(loginViewState = currentState.copy(isLoading = false))
                        }
                        sendNavEffect(LoginEffect.NavigateToHomeScreen)
                    }
                    Status.Error -> {
                        emitViewState {
                            this.copy(loginViewState = currentState.copy(isLoading = false))
                        }
                    }
                    Status.Loading -> {
                        emitViewState {
                            copy(
                                loginViewState = currentState.copy(isLoading = true)
                            )
                        }
                    }
                    null -> TODO()
                }
            }
        }
    }


}