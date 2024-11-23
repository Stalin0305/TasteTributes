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
        private const val registrationRoute = "registration_route"
        private const val homeScreenRoute = "home_screen_route"
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

    data object Registration: NavigationCommand(
        route = registrationRoute
    )

    data object HomeScreen: NavigationCommand(
        route = homeScreenRoute
    )

    fun withNavArgs(vararg args: Any?): String {
        return buildString {
            args.forEachIndexed { index, arg ->
                if (index == 0) append(arg) else append("/$arg")
            }
        }
    }
}