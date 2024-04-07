package com.example.quiz_extension

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz_extension.data.Record


@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    viewModel: ResultsViewModel,
    allUserScores: List<Record>,
){

    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen(navController = navController,
                viewModel = viewModel
            )
        }
        composable("quiz") {
            QuizScreen(navController = navController, questions = easy_list,
                viewModel = viewModel
            )
        }
        composable("last_screen") {
            FinalScreen(
                viewModel = viewModel,
                allUserScores = allUserScores
            )
        }

    }
}

