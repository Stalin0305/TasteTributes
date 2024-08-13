package com.example.tastetributes.features.login.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.tastetributes.features.login.ui.viewmodels.LoginViewModel
import com.example.tastetributes.features.login.ui.viewstates.LoginEffect
import com.example.tastetributes.features.login.ui.viewstates.LoginIntent
import com.example.tastetributes.features.login.ui.viewstates.LoginViewState
import com.example.tastetributes.features.login.ui.viewstates.ViewState
import com.example.tastetributes.foundation.NavEffect
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
            is LoginEffect.NavigateToHomeScreen -> {}
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