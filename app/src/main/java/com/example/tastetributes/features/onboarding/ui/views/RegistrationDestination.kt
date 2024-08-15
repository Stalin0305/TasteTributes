package com.example.tastetributes.features.onboarding.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tastetributes.features.onboarding.ui.viewmodels.RegistrationViewModel
import com.example.tastetributes.features.onboarding.ui.viewstates.registration.RegistrationIntent
import com.example.tastetributes.features.onboarding.ui.viewstates.registration.RegistrationNavEffect
import com.example.tastetributes.features.onboarding.ui.viewstates.registration.RegistrationViewState
import com.example.tastetributes.features.onboarding.ui.viewstates.registration.ViewState
import com.example.tastetributes.navigation.NavigationCommand
import com.example.tastetributes.navigation.NavigationManager
import com.example.tastetributes.ui.theme.TasteTributesTheme
import com.example.tastetributes.ui.theme.rememberWindowSizeClass
import kotlinx.coroutines.flow.Flow

@Composable
fun RegistrationDestination(
    paddingValues: PaddingValues,
    navigationManager: NavigationManager,
    viewModel: RegistrationViewModel,
    viewState: State<ViewState>,
    navEffect: Flow<RegistrationNavEffect>,
) {

    fun onUserAction(intent: RegistrationIntent) {
        viewModel.performAction(intent)
    }

    fun handleNavigation(navEffect: RegistrationNavEffect) {
        when (navEffect) {
            RegistrationNavEffect.NavigateBack -> {
                navigationManager.popBackStack()
            }

            RegistrationNavEffect.NavigateToHomeScreen -> {}
            RegistrationNavEffect.NavigateToLoginScreen -> navigationManager.navigateTo(
                NavigationCommand.Login
            )
        }
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.performAction(RegistrationIntent.DataLoadedIntent)
        navEffect.collect {
            handleNavigation(it)
        }
    }

    Box(modifier = Modifier) {
        when (viewState.value.registrationViewState) {
            is RegistrationViewState.DataLoaded -> {
                RegistrationLoadedScreen(
                    viewState = viewState.value.registrationViewState as RegistrationViewState.DataLoaded,
                    onUserAction = {
                        onUserAction(it)
                    })
            }

            RegistrationViewState.Loading -> {}
        }
    }


}


@Composable
@Preview(showBackground = true)
fun RegistrationPreview() {
    TasteTributesTheme(windowSizeClass = rememberWindowSizeClass()) {

    }
}
