package com.example.tastetributes.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tastetributes.features.onboarding.ui.viewmodels.LoginViewModel
import com.example.tastetributes.features.onboarding.ui.viewmodels.RegistrationViewModel
import com.example.tastetributes.features.onboarding.ui.views.LoginDestination
import com.example.tastetributes.features.onboarding.ui.views.OnBoardingScreen
import com.example.tastetributes.features.onboarding.ui.views.RegistrationDestination

@Composable
fun TasteTributeNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    navigationManager: NavigationManager,
) {
    NavHost(navController = navController, startDestination = NavigationCommand.Onboarding.route) {
        onboardingScreen(paddingValues, navigationManager)
        loginScreen(paddingValues, navigationManager)
        registrationScreen(paddingValues, navigationManager)
    }
}

fun NavGraphBuilder.onboardingScreen(paddingValues: PaddingValues, navigationManager: NavigationManager) {
    composable(NavigationCommand.Onboarding.route) {
        OnBoardingScreen(paddingValues, navigationManager = navigationManager)
    }
}

fun NavGraphBuilder.loginScreen(paddingValues: PaddingValues, navigationManager: NavigationManager) {
    composable(NavigationCommand.Login.route) {
        val viewModel = hiltViewModel<LoginViewModel>()
        val viewState = viewModel.viewState.collectAsState()
        val navEffect = viewModel.effect
        LoginDestination(
            paddingValues = paddingValues,
            navigationManager = navigationManager,
            viewModel = viewModel,
            viewState = viewState,
            navEffect = navEffect,
        )
    }
}

fun NavGraphBuilder.registrationScreen(paddingValues: PaddingValues, navigationManager: NavigationManager) {
    composable(NavigationCommand.Registration.route) {
        val viewModel = hiltViewModel<RegistrationViewModel>()
        val viewState = viewModel.viewState.collectAsState()
        val navEffect = viewModel.effect
        RegistrationDestination(
            paddingValues = paddingValues,
            navigationManager = navigationManager,
            viewModel = viewModel,
            viewState = viewState,
            navEffect = navEffect
        )
    }
}