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

    fun navigateTo(navCommandWithArgs: NavCommandWithArgs) {
        scope.launch {
            _navCommand.emit(navCommandWithArgs)
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