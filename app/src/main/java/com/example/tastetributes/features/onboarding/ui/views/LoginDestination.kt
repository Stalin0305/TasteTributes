package com.example.tastetributes.features.onboarding.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.tastetributes.features.onboarding.ui.viewmodels.LoginViewModel
import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginEffect
import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginIntent
import com.example.tastetributes.features.onboarding.ui.viewstates.login.LoginViewState
import com.example.tastetributes.features.onboarding.ui.viewstates.login.ViewState
import com.example.tastetributes.navigation.NavigationCommand
import com.example.tastetributes.navigation.NavigationManager
import kotlinx.coroutines.flow.Flow

@Composable
fun LoginDestination(
    paddingValues: PaddingValues,
    navigationManager: NavigationManager,
    viewModel: LoginViewModel,
    viewState: State<ViewState>,
    navEffect: Flow<LoginEffect>,
) {

    fun handleNavigation(navEffect: LoginEffect) {
        when (navEffect) {
            is LoginEffect.NavigateBack -> {}
            is LoginEffect.NavigateToHomeScreen -> {
                navigationManager.navigateTo(NavigationCommand.HomeScreen)
            }
            is LoginEffect.NavigateToRegistrationScreen -> {
                navigationManager.navigateTo(NavigationCommand.Registration)
            }
        }
    }

    fun onUserAction(intent: LoginIntent) {
        viewModel.performAction(intent)
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.performAction(LoginIntent.LoadData)
        navEffect.collect {
            handleNavigation(it)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when (viewState.value.loginViewState) {
            LoginViewState.UnInitialized -> {}
            LoginViewState.Loading -> {
            }

            is LoginViewState.LoadedData -> {
                LoginLoadedScreen(
                    viewState = viewState.value.loginViewState as LoginViewState.LoadedData,
                    onUserAction = {
                        onUserAction(it)
                    }
                )
            }

            else -> {}
        }
    }
}