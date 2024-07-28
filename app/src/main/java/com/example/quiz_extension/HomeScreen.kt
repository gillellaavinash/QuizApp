package com.example.quiz_extension

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController


@Composable
fun HomeScreen(navController: NavHostController,
               viewModel: ResultsViewModel,
               ) {
    var amount by remember {
        mutableStateOf("")
    }
    //val triviaResult = viewModel.triviaResult.observeAsState()
    val local = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(36.dp))
        OutlinedTextField(
            value = amount,
            onValueChange = {
                amount = it },
            label = {
                Text(text = "Enter no of questions")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if(amount<= 0.toString())
                Toast.makeText(local, "Please enter a positive number", Toast.LENGTH_SHORT).show()
            else {
                viewModel.getData(amount.toInt())
                navController.navigate("quiz/${amount.toInt()}")
            }
        }) {
            Text("Submit")
        }

    }
}

