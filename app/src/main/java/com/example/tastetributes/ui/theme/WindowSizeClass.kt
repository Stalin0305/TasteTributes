package com.example.tastetributes.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

sealed class WindowSize(val size: Int) {
    data class Small(val smallSize: Int) : WindowSize(smallSize)
    data class Compact(val compactSize: Int) : WindowSize(compactSize)
    data class Medium(val mediumSize: Int) : WindowSize(mediumSize)
    data class Large(val largeSize: Int) : WindowSize(largeSize)
}

data class WindowSizeClass(
    val width: WindowSize,
    val height: WindowSize,
)

@Composable
fun rememberWindowSizeClass(): WindowSizeClass {
    val config = LocalConfiguration.current
    val width by remember {
        mutableStateOf(config.screenWidthDp)
    }

    val height by remember {
        mutableStateOf(config.screenHeightDp)
    }

    val widthWindowSize = when (width) {
        in 0..360 -> WindowSize.Small(width)
        in 361..480 -> WindowSize.Compact(width)
        in 481..720 -> WindowSize.Medium(width)
        else -> WindowSize.Large(width)
    }

    val heightWindowSize = when (height) {
        in 0..360 -> WindowSize.Small(height)
        in 361..480 -> WindowSize.Compact(height)
        in 481..720 -> WindowSize.Medium(height)
        else -> WindowSize.Large(height)
    }
    return WindowSizeClass(widthWindowSize, heightWindowSize)
}