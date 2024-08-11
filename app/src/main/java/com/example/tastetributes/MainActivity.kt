package com.example.tastetributes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tastetributes.navigation.NavigationCommand
import com.example.tastetributes.navigation.NavigationManager
import com.example.tastetributes.navigation.TasteTributeNavGraph
import com.example.tastetributes.navigation.navigateToDestination
import com.example.tastetributes.navigation.popBackStack
import com.example.tastetributes.ui.theme.TasteTributesTheme
import com.example.tastetributes.ui.theme.WindowSizeClass
import com.example.tastetributes.ui.theme.rememberWindowSizeClass
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = rememberWindowSizeClass()
            enableEdgeToEdge()
            TasteTributeThemeContent(windowSizeClass = windowSizeClass)
        }
    }

    private fun observeNavigationCommand(navController: NavHostController) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                navigationManager.navCommand.collect {
                    when (it.navigationCommand) {
                        NavigationCommand.PopBackStack -> popBackStack(navController)
                        else -> navigateToDestination(
                            it.navigationCommand,
                            it.arguments,
                            navController
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun TasteTributeThemeContent(windowSizeClass: WindowSizeClass) {
        TasteTributesTheme(windowSizeClass = windowSizeClass) {
            val padding = remember {
                mutableStateOf(PaddingValues())
            }

            val navController = rememberNavController()
            observeNavigationCommand(navController)

            Scaffold { paddingValues ->
                TasteTributeNavGraph(navController = navController, paddingValues, navigationManager)
            }
        }
    }
}