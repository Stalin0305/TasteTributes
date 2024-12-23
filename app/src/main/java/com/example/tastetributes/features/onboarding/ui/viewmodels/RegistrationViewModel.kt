package com.example.tastetributes.features.onboarding.ui.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.tastetributes.features.onboarding.data.models.CreateUserRequest
import com.example.tastetributes.features.onboarding.domain.usecases.CreateAccountUseCase
import com.example.tastetributes.features.onboarding.ui.viewstates.registration.RegistrationIntent
import com.example.tastetributes.features.onboarding.ui.viewstates.registration.RegistrationNavEffect
import com.example.tastetributes.features.onboarding.ui.viewstates.registration.RegistrationViewState
import com.example.tastetributes.features.onboarding.ui.viewstates.registration.ViewState
import com.example.tastetributes.foundation.MviViewModel
import com.example.tastetributes.utils.Status
import com.example.tastetributes.utils.isConfirmPasswordValid
import com.example.tastetributes.utils.isEmailValid
import com.example.tastetributes.utils.isPasswordValid
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val createAccountUseCase: CreateAccountUseCase,
) :
    MviViewModel<RegistrationIntent, ViewState, RegistrationNavEffect>() {
    override fun createInitialState(): ViewState {
        return ViewState(RegistrationViewState.Loading)
    }

    override fun handleIntent(intent: RegistrationIntent) {
        when (intent) {
            RegistrationIntent.DataLoadedIntent -> {
                emitViewState {
                    copy(
                        registrationViewState = RegistrationViewState.DataLoaded()
                    )
                }
            }

            is RegistrationIntent.HandleConfirmPasswordChangedIntent -> {
                val currentState =
                    viewState.value.registrationViewState as RegistrationViewState.DataLoaded
                emitViewState {
                    copy(
                        registrationViewState = currentState.copy(
                            confirmPassword = intent.confirmPassword,
                            isConfirmPasswordInvalid = intent.confirmPassword.isConfirmPasswordValid(
                                currentState.password
                            ).not(),
                        )
                    )
                }
                checkAllFieldsValidation()
            }

            is RegistrationIntent.HandleEmailChangedIntent -> {
                val currentState =
                    viewState.value.registrationViewState as RegistrationViewState.DataLoaded
                emitViewState {
                    copy(
                        registrationViewState = currentState.copy(
                            email = intent.email,
                            isEmailInvalid = intent.email.isEmailValid().not(),
                        )
                    )
                }
                checkAllFieldsValidation()
            }

            is RegistrationIntent.HandleNameChangedIntent -> {
                val currentState =
                    viewState.value.registrationViewState as RegistrationViewState.DataLoaded
                emitViewState {
                    copy(
                        registrationViewState = currentState.copy(
                            name = intent.name,
                        )
                    )
                }
                checkAllFieldsValidation()
            }

            is RegistrationIntent.HandlePasswordChangedIntent -> {
                val currentState =
                    viewState.value.registrationViewState as RegistrationViewState.DataLoaded
                emitViewState {
                    copy(
                        registrationViewState = currentState.copy(
                            password = intent.password,
                            isPasswordInvalid = intent.password.isPasswordValid().not(),
                            isConfirmPasswordInvalid = currentState.confirmPassword.isConfirmPasswordValid(
                                intent.password
                            ).not()
                        )
                    )
                }
                checkAllFieldsValidation()
            }

            RegistrationIntent.HandleRegistrationButtonClickedIntent -> {
                val currentState =
                    currentState.registrationViewState as RegistrationViewState.DataLoaded
                if (currentState.isSignUpButtonEnabled) {
                    emitViewState {
                        copy(
                            registrationViewState = currentState.copy(isLoading = true)
                        )
                    }
                    createNewAccount()
                }
            }

            RegistrationIntent.HandleSignInButtonClickedIntent -> {
                sendNavEffect(RegistrationNavEffect.NavigateBack)
            }

            is RegistrationIntent.HandleTermsConditionCheckBoxIntent -> {
                val currentState =
                    viewState.value.registrationViewState as RegistrationViewState.DataLoaded
                emitViewState {
                    copy(
                        registrationViewState = currentState.copy(
                            isTermsAccepted = intent.isChecked,
                        )
                    )
                }
                checkAllFieldsValidation()
            }

            RegistrationIntent.DismissToast -> {
                val currentState =
                    viewState.value.registrationViewState as RegistrationViewState.DataLoaded
                emitViewState {
                    copy(
                        registrationViewState = currentState.copy(shouldShowToast = false)
                    )
                }
            }
        }
    }

    private fun createNewAccount() {
        val currentState = currentState.registrationViewState as RegistrationViewState.DataLoaded
        viewModelScope.launch {
            createAccountUseCase.invoke(
                CreateUserRequest(
                    name = currentState.name,
                    email = currentState.email,
                    password = currentState.password
                )
            ).collect { userData ->
                userData?.let {
                    when (it.status) {
                        Status.Success -> {
                            emitViewState {
                                copy(
                                    registrationViewState = currentState.copy(
                                        isLoading = false
                                    )
                                )
                            }
                            sendNavEffect(RegistrationNavEffect.NavigateToHomeScreen)
                        }

                        Status.Error -> {
                            emitViewState {
                                copy(
                                    registrationViewState = currentState.copy(
                                        isLoading = false,
                                        shouldShowToast = true,
                                        toastMessage = it.error
                                    )
                                )
                            }
                        }

                        Status.Loading -> {
                            emitViewState {
                                copy(
                                    registrationViewState = currentState.copy(
                                        isLoading = false,
                                    )
                                )
                            }
                        }
                    }
                } ?: emitViewState {
                    copy(
                        registrationViewState = currentState.copy(
                            isLoading = false,
                            shouldShowToast = true,
                            toastMessage = "Something went wrong. Please try again."
                        )
                    )
                }
            }
        }
    }

    private fun isButtonEnabled(): Boolean {
        val currentState = currentState.registrationViewState as RegistrationViewState.DataLoaded
        return !(currentState.isPasswordInvalid ||
                currentState.isEmailInvalid || currentState.isConfirmPasswordInvalid ||
                currentState.isTermsAccepted.not() || currentState.name.isBlank())
    }

    private fun checkAllFieldsValidation() {
            val currentState = currentState.registrationViewState as RegistrationViewState.DataLoaded
            emitViewState {
                copy(registrationViewState = currentState.copy(
                    isSignUpButtonEnabled = isButtonEnabled()
                ))
            }
    }
}