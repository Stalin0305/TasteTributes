package com.example.expensetracker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tastetributes.R

// Set of Material typography styles to start with
//val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    )
//    /* Other default text styles to override
//    titleLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 22.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
//    ),
//    labelSmall = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    )
//    */
//)

val customFontFamily = FontFamily(
    Font(resId = R.font.josefinsans_regular, weight = FontWeight.Normal),
    Font(resId = R.font.josefinsans_medium, weight = FontWeight.Medium),
    Font(resId = R.font.josefinsans_bold, weight = FontWeight.Bold)
)

//data class ExpenseTrackerTypography(
//    val expenseTrackerTypography: Typography,
//    val
//)

//data class Typography(
//    val h1: TextStyle,
//    val h2: TextStyle,
//    val h3: TextStyle,
//    val h4: TextStyle,
//    val h5: TextStyle,
//    val h6: TextStyle,
//    val title: TextStyle,
//    val subtitle: TextStyle,
//    val body: TextStyle,
//)
//
//val smallTypography = Typography(
//    h1 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 24.sp
//    ),
//    h2 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 20.sp
//    ),
//    h3 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 18.sp
//    ),
//    h4 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 16.sp
//    ),
//    h5 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 14.sp
//    ),
//    h6 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 12.sp
//    ),
//    title = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 24.sp
//    ),
//    subtitle = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 18.sp
//    ),
//    body = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 14.sp
//    ),
//)
//
//val compactTypography =  Typography(
//    h1 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 28.sp
//    ),
//    h2 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 24.sp
//    ),
//    h3 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 20.sp
//    ),
//    h4 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 18.sp
//    ),
//    h5 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 16.sp
//    ),
//    h6 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 14.sp
//    ),
//    title = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 28.sp
//    ),
//    subtitle = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 24.sp
//    ),
//    body = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 16.sp
//    ),
//)
//
//val mediumTypography =  Typography(
//    h1 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 32.sp
//    ),
//    h2 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 28.sp
//    ),
//    h3 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 24.sp
//    ),
//    h4 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 20.sp
//    ),
//    h5 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 18.sp
//    ),
//    h6 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 16.sp
//    ),
//    title = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 32.sp
//    ),
//    subtitle = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 28.sp
//    ),
//    body = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 18.sp
//    ),
//)
//
//val largeTypography =  Typography(
//    h1 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 36.sp
//    ),
//    h2 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 30.sp
//    ),
//    h3 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 28.sp
//    ),
//    h4 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 24.sp
//    ),
//    h5 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 20.sp
//    ),
//    h6 = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 18.sp
//    ),
//    title = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 28.sp
//    ),
//    subtitle = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 24.sp
//    ),
//    body = TextStyle(
//        fontFamily = customFontFamily,
//        fontSize = 18.sp
//    ),
//)
//
//val LocalTypography = compositionLocalOf { mediumTypography }

val smallTypography = Typography(
    displayLarge = TextStyle(
        fontSize = 48.sp,
        fontFamily = customFontFamily
    ),
    displayMedium = TextStyle(
        fontSize = 36.sp,
        fontFamily = customFontFamily
    ),
    displaySmall = TextStyle(
        fontSize = 30.sp,
        fontFamily = customFontFamily
    ),
    headlineLarge = TextStyle(
        fontSize = 28.sp,
        fontFamily = customFontFamily
    ),
    headlineMedium = TextStyle(
        fontSize = 24.sp,
        fontFamily = customFontFamily
    ),
    headlineSmall = TextStyle(
        fontSize = 20.sp,
        fontFamily = customFontFamily
    ),
    titleLarge = TextStyle(
        fontSize = 18.sp,
        fontFamily = customFontFamily
    ),
    titleMedium = TextStyle(
        fontSize = 14.sp,
        fontFamily = customFontFamily
    ),
    titleSmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = customFontFamily
    ),
    labelLarge = TextStyle(
        fontSize = 12.sp,
        fontFamily = customFontFamily
    ),
    labelMedium = TextStyle(
        fontSize = 10.sp,
        fontFamily = customFontFamily
    ),
    labelSmall = TextStyle(
        fontSize = 9.sp,
        fontFamily = customFontFamily
    ),
    bodyLarge = TextStyle(
        fontSize = 14.sp,
        fontFamily = customFontFamily
    ),
    bodyMedium = TextStyle(
        fontSize = 12.sp,
        fontFamily = customFontFamily
    ),
    bodySmall = TextStyle(
        fontSize = 10.sp,
        fontFamily = customFontFamily
    ),
)

val compactTypography = Typography(
    displayLarge = TextStyle(
        fontSize = 52.sp,
        fontFamily = customFontFamily
    ),
    displayMedium = TextStyle(
        fontSize = 40.sp,
        fontFamily = customFontFamily
    ),
    displaySmall = TextStyle(
        fontSize = 34.sp,
        fontFamily = customFontFamily
    ),
    headlineLarge = TextStyle(
        fontSize = 30.sp,
        fontFamily = customFontFamily
    ),
    headlineMedium = TextStyle(
        fontSize = 26.sp,
        fontFamily = customFontFamily
    ),
    headlineSmall = TextStyle(
        fontSize = 22.sp,
        fontFamily = customFontFamily
    ),
    titleLarge = TextStyle(
        fontSize = 20.sp,
        fontFamily = customFontFamily
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = customFontFamily
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = customFontFamily
    ),
    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontFamily = customFontFamily
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        fontFamily = customFontFamily
    ),
    labelSmall = TextStyle(
        fontSize = 10.sp,
        fontFamily = customFontFamily
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontFamily = customFontFamily
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontFamily = customFontFamily
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = customFontFamily
    ),
)

val mediumTypography = Typography(
    displayLarge = TextStyle(
        fontSize = 54.sp,
        fontFamily = customFontFamily
    ),
    displayMedium = TextStyle(
        fontSize = 42.sp,
        fontFamily = customFontFamily
    ),
    displaySmall = TextStyle(
        fontSize = 36.sp,
        fontFamily = customFontFamily
    ),
    headlineLarge = TextStyle(
        fontSize = 32.sp,
        fontFamily = customFontFamily
    ),
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontFamily = customFontFamily
    ),
    headlineSmall = TextStyle(
        fontSize = 24.sp,
        fontFamily = customFontFamily
    ),
    titleLarge = TextStyle(
        fontSize = 22.sp,
        fontFamily = customFontFamily
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = customFontFamily
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = customFontFamily
    ),
    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontFamily = customFontFamily
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        fontFamily = customFontFamily
    ),
    labelSmall = TextStyle(
        fontSize = 11.sp,
        fontFamily = customFontFamily
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontFamily = customFontFamily
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontFamily = customFontFamily
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = customFontFamily
    ),
)

val largeTypography = Typography(
    displayLarge = TextStyle(
        fontSize = 57.sp,
        fontFamily = customFontFamily
    ),
    displayMedium = TextStyle(
        fontSize = 45.sp,
        fontFamily = customFontFamily
    ),
    displaySmall = TextStyle(
        fontSize = 36.sp,
        fontFamily = customFontFamily
    ),
    headlineLarge = TextStyle(
        fontSize = 32.sp,
        fontFamily = customFontFamily
    ),
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontFamily = customFontFamily
    ),
    headlineSmall = TextStyle(
        fontSize = 24.sp,
        fontFamily = customFontFamily
    ),
    titleLarge = TextStyle(
        fontSize = 22.sp,
        fontFamily = customFontFamily
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = customFontFamily
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = customFontFamily
    ),
    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontFamily = customFontFamily
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        fontFamily = customFontFamily
    ),
    labelSmall = TextStyle(
        fontSize = 11.sp,
        fontFamily = customFontFamily
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontFamily = customFontFamily
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontFamily = customFontFamily
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = customFontFamily
    ),
)