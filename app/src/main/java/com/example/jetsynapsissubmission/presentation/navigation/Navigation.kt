package com.example.jetsynapsissubmission.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetsynapsissubmission.presentation.screen.survei.SurveiScreen
import com.example.jetsynapsissubmission.presentation.screen.login.LoginScreen

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Login.route ){
        composable(Screen.Login.route){
            LoginScreen(navHostController = navHostController)
        }
        composable(Screen.Survei.route){
            SurveiScreen(navHostController = navHostController)
        }
    }
}