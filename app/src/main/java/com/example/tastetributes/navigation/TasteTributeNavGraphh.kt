package com.example.tastetributes.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tastetributes.onboarding.ui.views.OnBoardingScreen

@Composable
fun TasteTributeNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(navController = navController, startDestination = NavigationCommand.Onboarding.route) {
        composable(NavigationCommand.Onboarding.route) {
            OnBoardingScreen(paddingValues)
        }
    }
}