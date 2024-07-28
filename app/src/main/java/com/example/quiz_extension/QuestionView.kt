package com.example.quiz_extension

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.currencycon.api.NetworkResponse
import com.example.currencycon.api.Trivia
import kotlin.random.Random
import kotlin.reflect.KProperty

@Composable
fun QuestionScreen(
    viewModel: ResultsViewModel,
    navController: NavHostController,
    backStackEntry: NavBackStackEntry,
) {
    val count = backStackEntry.arguments?.getInt("amount")
    val trivia = viewModel.triviaResult.observeAsState()
    Column(
         modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(val result = trivia.value){
            is NetworkResponse.Error -> {
                Text(text = result.message)
            }
            NetworkResponse.Loading -> {
                CircularProgressIndicator()
            }
            is NetworkResponse.Success -> {
                //Text(text = "${result.data}")
                if (count != null) {
                    QuizScreen(data = result.data,count = count,navController)
                }
            }
            null -> {
                Text(text = "Enter City")
            }
        }
    }
}


@Composable
fun QuizScreen(data: Trivia, count: Int, navController: NavHostController) {
    var currentQuestion by remember { mutableIntStateOf(0) } // Track current question index
    var score by remember { mutableIntStateOf(0) }

    var question = data.results[currentQuestion]

    val brush = Brush.linearGradient(
        colors = listOf(Color.Red,
            Color.Blue,
            Color.Green,
            Color.Yellow,
            Color.Magenta,
            Color.Cyan,
            )
    )

    val list = listOf(
        data.results[currentQuestion].correct_answer,
        data.results[currentQuestion].incorrect_answers[0],
        data.results[currentQuestion].incorrect_answers[1],
        data.results[currentQuestion].incorrect_answers[2]
    )
    val listOptions = list
    val correctAnswer = data.results[currentQuestion].correct_answer
    Column(
        modifier = Modifier.fillMaxSize()
            .background(brush),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(25.dp)
    ){
        Text(text = data.results[currentQuestion].question,
            modifier = Modifier
                .padding(45.dp),
            fontSize = 26.sp)
        Spacer(modifier = Modifier.height(120.dp))
        //question.options.forEachIndexed { index, option ->
            var color1 by remember {
                mutableStateOf(Color.White)
            }
            var color2 by remember {
                mutableStateOf(Color.White)
            }
            var color3 by remember {
                mutableStateOf(Color.White)
            }
            var color4 by remember {
                mutableStateOf(Color.White)
            }
            Button(
                onClick = {
                    if (list[0] == correctAnswer) {
                        score++
                        color1 = Color.Green
                    }else{
                        color1 = Color.Red
                    }
                    //resetButtonColors()
                },
                modifier = Modifier
                    .background(
                        when(color1){
                            Color.Green -> Color.Green
                            Color.Red -> Color.Red
                            else -> Color.White
                        }
                    ),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = color1
                ),
                )
            {
                Text(
                    text = list[0],
                    fontSize = 24.sp,
                    color = Color.Blue
                )
            }

        Button(
            onClick = {
                if (list[1] == correctAnswer) {
                    score++
                    color2 = Color.Green
                }else{
                    color2 = Color.Red
                }
                //resetButtonColors()
            },
            modifier = Modifier
                .background(
                    when(color2){
                        Color.Green -> Color.Green
                        Color.Red -> Color.Red
                        else -> Color.White
                    }
                ),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = color2
            ),
        )
        {
            Text(
                text = list[1],
                fontSize = 24.sp,
                color = Color.Blue
            )
        }
        Button(
            onClick = {
                if (list[2] == correctAnswer) {
                    score++
                    color3 = Color.Green
                }else{
                    color3 = Color.Red
                }
                //resetButtonColors()
            },
            modifier = Modifier
                .background(
                    when(color3){
                        Color.Green -> Color.Green
                        Color.Red -> Color.Red
                        else -> Color.White
                    }
                ),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = color3
            ),
        )
        {
            Text(
                text = list[2],
                fontSize = 24.sp,
                color = Color.Blue
            )
        }
        Button(
            onClick = {
                if (listOptions[3] == correctAnswer) {
                    score++
                    color4 = Color.Green
                }else{
                    color4 = Color.Red
                }
                //resetButtonColors()
            },
            modifier = Modifier
                .background(
                    when(color4){
                        Color.Green -> Color.Green
                        Color.Red -> Color.Red
                        else -> Color.White
                    }
                ),
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = color4
            ),
        )
        {
            Text(text = listOptions[3],
                fontSize = 24.sp,
                color = Color.Blue
            )
        }
        //}
            Spacer(modifier = Modifier.height(80.dp))

            if (currentQuestion < count - 1){
                Button(onClick = { currentQuestion++ 
                    color1 = Color.White
                    color2 = Color.White
                    color3 = Color.White
                    color4 = Color.White
                }) {
                    Text(text = "Next",
                        fontSize = 24.sp,
                        color = Color.Black
                        )
                }
                //question = questions[currentQuestion]
            }else{
                Button(onClick = {
                   // viewModel = score
                    navController.navigate("last_screen")
                }) {
                    Text(text = "Finish",
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                }
            }
    }

}




