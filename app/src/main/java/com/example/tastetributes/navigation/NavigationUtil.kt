package com.example.tastetributes.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.navArgument
import org.json.JSONObject

fun navigateToDestination(
    navigationCommand: NavigationCommand,
    arguments: Any?,
    navController: NavController,
) {
    val route = navigationCommand.route
    arguments?.let {
        route.plus("/").plus(it)
    }
    navController.navigate(route)
}

fun popBackStack(navController: NavController) {
    navController.popBackStack()
}