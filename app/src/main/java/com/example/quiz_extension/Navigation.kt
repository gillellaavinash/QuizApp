package com.example.quiz_extension

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Navigation(
    viewModel: ResultsViewModel,
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen(navController = navController,
                viewModel = viewModel
            )
        }
        composable("quiz/{amount}",
            arguments = listOf(
                navArgument("amount")
                { type = NavType.IntType }
            )
        ) { backStackEntry ->
            QuestionScreen(navController = navController,
                viewModel = viewModel,
                backStackEntry = backStackEntry
            )
        }
    }
}

