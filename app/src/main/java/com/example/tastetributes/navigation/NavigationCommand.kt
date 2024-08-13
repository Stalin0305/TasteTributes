package com.example.tastetributes.navigation

import androidx.navigation.NamedNavArgument

sealed class NavigationCommand(
    val route: String,
    val arguments: List<NamedNavArgument> = listOf()
) {

    companion object {
        private const val onBoardingRoute = "on_boarding_route"
        private const val popBackStackRoute = "pop_back_stack_route"
        private const val loginRoute = "login_route"
    }

    data object PopBackStack: NavigationCommand(
        route = popBackStackRoute
    )

    data object Onboarding: NavigationCommand(
        route = onBoardingRoute
    )

    data object Login: NavigationCommand(
        route = loginRoute
    )

    fun withNavArgs(vararg args: Any?): String {
        return buildString {
            args.forEachIndexed { index, arg ->
                if (index == 0) append(arg) else append("/$arg")
            }
        }
    }
}