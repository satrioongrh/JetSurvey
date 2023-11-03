package com.example.jetsynapsissubmission.presentation.navigation

sealed class Screen (val route: String) {

    object Login: Screen("login")
    object Survei: Screen("survei")

}