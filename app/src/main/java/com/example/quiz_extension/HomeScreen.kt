package com.example.quiz_extension

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun HomeScreen(navController: NavHostController, viewModel: ResultsViewModel) {
    var name by remember {
        mutableStateOf("")
    }
    var isError by remember {
        mutableStateOf(false)
    }
    var selected by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            value = name,
            onValueChange = {newValue ->
                name = newValue
            },
            enabled = true,
            placeholder = {
                Text("Enter your name")
            },
            supportingText = {
                Text("Enter Name here")
            },
            isError = isError,
            label = {
                Text("Name")
            }
        )


        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 250.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            RadioButton(
                selected = selected == "Easy",
                onClick = {
                    selected = "Easy"
                })
            Text(
                text = "Easy",
                modifier = Modifier.padding(start = (16).dp, bottom = 16.dp))
            RadioButton(
                selected = selected == "Medium",
                onClick = {
                    selected = "Medium"
                })
            Text(
                text = "Medium",
                modifier = Modifier.padding(start = (16).dp, bottom = 16.dp)
            )
            RadioButton(
                selected = selected == "Hard",
                onClick = {
                    selected = "Hard"
                })
            Text(
                text = "Hard",
                modifier = Modifier.padding(start = (16).dp, bottom = 16.dp))
        }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 125.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(
                    onClick = {
                        isError = name.isEmpty()
                        if (!isError && selected != "") {
                            viewModel.name = name
                            navController.navigate("quiz")
                        }
                    },
                )
                {
                    Text(text = "Submit")
                }
            }
    }
}

