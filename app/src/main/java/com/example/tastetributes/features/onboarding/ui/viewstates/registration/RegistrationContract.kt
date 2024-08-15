package com.example.tastetributes.features.onboarding.ui.viewstates.registration

import android.widget.Toast
import com.example.tastetributes.foundation.NavEffect
import com.example.tastetributes.foundation.UserIntent
import com.example.tastetributes.foundation.ViewState
import com.example.tastetributes.utils.Constants.EMPTY_STRING

data class ViewState(val registrationViewState: RegistrationViewState) : ViewState


sealed class RegistrationViewState() {
    data object Loading : RegistrationViewState()

    data class DataLoaded(
        val name: String = EMPTY_STRING,
        val email: String = EMPTY_STRING,
        val password: String = EMPTY_STRING,
        val confirmPassword: String = EMPTY_STRING,
        val isTermsAccepted: Boolean = false,
        val isLoading: Boolean = false,
        val toastMessage: String = EMPTY_STRING,
        val shouldShowToast: Boolean = false,

        ) : RegistrationViewState()
}

sealed class RegistrationIntent : UserIntent {
    data class HandleNameChangedIntent(
        val name: String,
    ) : RegistrationIntent()

    data class HandleEmailChangedIntent(
        val email: String,
    ) : RegistrationIntent()

    data class HandlePasswordChangedIntent(
        val password: String,
    ) : RegistrationIntent()

    data class HandleConfirmPasswordChangedIntent(
        val confirmPassword: String,
    ) : RegistrationIntent()

    data class HandleTermsConditionCheckBoxIntent(
        val isChecked: Boolean,
    ) : RegistrationIntent()

    data object HandleRegistrationButtonClickedIntent : RegistrationIntent()

    data object HandleSignInButtonClickedIntent: RegistrationIntent()

    data object DataLoadedIntent: RegistrationIntent()

    data object DismissToast: RegistrationIntent()
}

sealed class RegistrationNavEffect : NavEffect {
    data object NavigateBack : RegistrationNavEffect()

    data object NavigateToLoginScreen : RegistrationNavEffect()

    data object NavigateToHomeScreen : RegistrationNavEffect()
}