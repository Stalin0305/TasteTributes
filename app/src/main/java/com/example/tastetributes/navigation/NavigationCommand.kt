package com.example.tastetributes.navigation

import androidx.navigation.NamedNavArgument

sealed class NavigationCommand(
    val route: String,
    val arguments: List<NamedNavArgument> = listOf()
) {

    companion object {
        const val onBoardingRoute = "on_boarding_route"
        const val popBackStackRoute = "pop_back_stack_route"
    }

    object PopBackStack: NavigationCommand(
        route = popBackStackRoute
    )

    object Onboarding: NavigationCommand(
        route = onBoardingRoute
    )

    fun withNavArgs(vararg args: Any?): String {
        return buildString {
            args.forEachIndexed { index, arg ->
                if (index == 0) append(arg) else append("/$arg")
            }
        }
    }
}