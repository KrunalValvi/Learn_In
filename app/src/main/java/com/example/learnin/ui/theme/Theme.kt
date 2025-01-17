package com.example.learnin.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

// Define the dark color scheme
private val DarkColorScheme = darkColorScheme(
    primary = PrimaryMain,
    secondary = SecondaryMain,
    tertiary = Orange,
    background = MidDark,
    surface = Darkest,
    error = Color.Red, // Use Color.Red for the error color
    onPrimary = WhiteHighEmp,
    onSecondary = WhiteHighEmp,
    onTertiary = WhiteHighEmp,
    onBackground = WhiteHighEmp,
    onSurface = WhiteHighEmp,
    onError = WhiteHighEmp
)

// Define the light color scheme
private val LightColorScheme = lightColorScheme(
    primary = PrimaryMain,
    secondary = SecondaryMain,
    tertiary = Orange,
    background = WhiteHighEmp,
    surface = WhiteLowEmp,
    error = Color.Red, // Use Color.Red for the error color
    onPrimary = BlackHighEmp,
    onSecondary = BlackHighEmp,
    onTertiary = BlackHighEmp,
    onBackground = BlackHighEmp,
    onSurface = BlackHighEmp,
    onError = BlackHighEmp
)

@Composable
fun LearnInTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Automatically detect dark mode
    dynamicColor: Boolean = true, // Use dynamic colors on Android 12+ (optional)
    content: @Composable () -> Unit
) {
    // Select the color scheme based on conditions
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // Update system bars (status bar color)
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.setDecorFitsSystemWindows(window, false)
            WindowInsetsControllerCompat(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    // Apply the custom typography and color scheme to MaterialTheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Use your custom Typography defined in `type.kt`
        content = content
    )
}

// Define additional theme colors
val LightBackground = Color(0xFFFFFFFF)
val LightCardColor = Color(0xFFFCECDB)
val LightRowColor = Color(0xFF335EEA) // Blue
val LightButtonColor = Color(0xFF335EEA)
val LightTextColor = Color.Black

val DarkBackground = Color(0xFF151B22)
val DarkCardColor = Color(0xFF30373D)
val DarkRowColor = Color(0xFFEE7B59) // Orange
val DarkButtonColor = Color(0xFF657FF3)
val DarkTextColor = Color.White

data class ThemeColors(
    val onboardingBackground1: Brush,
    val background: Color,
    val cardColor: Color,
    val rowColor: Color,
    val buttonColor: Color,
    val textColor: Color
)

@Composable
fun getCurrentThemeColors(): ThemeColors {
    val isDarkTheme = isSystemInDarkTheme()
    return if (isDarkTheme) {
        ThemeColors(
            onboardingBackground1 = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFDEE9FF),
                    Color(0xFFFFFFFF)
                )
            ),
            background = DarkBackground,
            cardColor = DarkCardColor,
            rowColor = DarkRowColor,
            buttonColor = DarkButtonColor,
            textColor = DarkTextColor
        )
    } else {
        ThemeColors(
            onboardingBackground1 = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF535353),
                    Color(0xFF7a7a7a)
                )
            ),
            background = LightBackground,
            cardColor = LightCardColor,
            rowColor = LightRowColor,
            buttonColor = LightButtonColor,
            textColor = LightTextColor
        )
    }
}