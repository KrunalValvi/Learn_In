package com.example.learnin.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learnin.ui.auth.screens.CongratulationsScreen
import com.example.learnin.ui.auth.screens.Loginscreen
import com.example.learnin.ui.auth.screens.OtpScreen
import com.example.learnin.ui.auth.screens.SignUpScreen
import com.example.learnin.ui.home.screens.HomeScreen
import com.example.learnin.ui.onboarding.screens.Onboarding1
import com.example.learnin.ui.onboarding.screens.Onboarding2
import com.example.learnin.ui.onboarding.screens.Onboarding3
import com.example.learnin.ui.onboarding.screens.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("onboarding") { Onboarding1(navController) }
        composable("onboarding2") { Onboarding2(navController) }
        composable("onboarding3") { Onboarding3(navController) }
        composable("LoginScreen") { Loginscreen(navController) }
        composable("SignUpScreen") { SignUpScreen(navController) }
        composable("OtpScreen") { OtpScreen(navController) }
        composable("CongratulationsScreen") { CongratulationsScreen(navController) }
        composable("HomeScreen") { HomeScreen(navController) }

        // Add more composables for other screens if needed
    }
}
