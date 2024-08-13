package com.example.tastetributes.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tastetributes.features.login.ui.viewmodels.LoginViewModel
import com.example.tastetributes.features.login.ui.views.LoginDestination
import com.example.tastetributes.features.onboarding.ui.views.OnBoardingScreen

@Composable
fun TasteTributeNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    navigationManager: NavigationManager,
) {
    NavHost(navController = navController, startDestination = NavigationCommand.Onboarding.route) {
        onboardingGraph(paddingValues, navigationManager)
        loginScreen(paddingValues, navigationManager)
    }
}

fun NavGraphBuilder.onboardingGraph(paddingValues: PaddingValues, navigationManager: NavigationManager) {
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