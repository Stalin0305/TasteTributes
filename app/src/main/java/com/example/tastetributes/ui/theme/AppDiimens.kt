package com.example.tastetributes.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class Orientation {
    PORTRAIT, LANDSCAPE
}

data class Dimensions(
    val small: Dp,
    val smallMedium: Dp,
    val medium: Dp,
    val mediumLarge: Dp,
    val large: Dp,
    val extraLarge: Dp,
)

val smallDimensions = Dimensions(
    small = 1.dp,
    smallMedium = 2.dp,
    medium = 4.dp,
    mediumLarge = 6.dp,
    large = 8.dp,
    extraLarge = 16.dp
)

val compactDimensions = Dimensions(
    small = 2.dp,
    smallMedium = 4.dp,
    medium = 6.dp,
    mediumLarge = 8.dp,
    large = 12.dp,
    extraLarge = 16.dp
)

val mediumDimensions = Dimensions(
    small = 4.dp,
    smallMedium = 6.dp,
    medium = 8.dp,
    mediumLarge = 12.dp,
    large = 16.dp,
    extraLarge = 24.dp
)

val largeDimensions = Dimensions(
    small = 8.dp,
    smallMedium = 12.dp,
    medium = 16.dp,
    mediumLarge = 24.dp,
    large = 32.dp,
    extraLarge = 48.dp
)

val LocalDimensions = compositionLocalOf { smallDimensions }

@Composable
fun ProvideAppUtils(dimensions: Dimensions, content: @Composable () -> Unit) {
    val dimSet = remember { dimensions }
    CompositionLocalProvider(LocalDimensions provides dimSet, content = content)
}