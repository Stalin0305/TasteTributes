package com.example.tastetributes.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


data class NavCommandWithArgs(
    val navigationCommand: NavigationCommand,
    val arguments: Any? = null,
)

class NavigationManager(private val scope: CoroutineScope) {

    private val _navCommand = MutableSharedFlow<NavCommandWithArgs>()

    val navCommand = _navCommand.asSharedFlow()

    fun navigateTo(navigationCommand: NavigationCommand, arguments: Any? = null) {
        scope.launch {
            _navCommand.emit(NavCommandWithArgs(
                navigationCommand = navigationCommand,
                arguments = navigationCommand.withNavArgs(arguments)
            ))
        }
    }

    fun popBackStack() {
        scope.launch {
            _navCommand.emit(
                NavCommandWithArgs(
                    navigationCommand = NavigationCommand.PopBackStack
                )
            )
        }
    }
}