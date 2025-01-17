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
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Define the dark color scheme
private val DarkColorScheme = darkColorScheme(
    primary = PrimaryMain,
    secondary = SecondaryMain,
    tertiary = Orange,
    background = MidDark,
    surface = Darkest,
    error = Error,
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
    error = Error,
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
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    // Apply the custom typography and color scheme to MaterialTheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Use your custom Typography defined in `type.kt`
        content = content
    )
}
