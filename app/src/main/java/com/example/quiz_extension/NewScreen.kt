package com.example.quiz_extension

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quiz_extension.data.Record

@Composable
fun FinalScreen(

) {

//    LaunchedEffect(key1 = Unit) {
//        viewModel.saveUserScore(
//            userName = viewModel.name, score = viewModel.correctAnswers
//        )
//    }
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .background(Color.Cyan),
//    ) {
//        Text(
//            text = "Results",
//            modifier = Modifier.padding(16.dp),
//            textAlign = TextAlign.Center,
//            style = TextStyle(
//                color = Color.Black,
//                fontSize = 30.sp,
//                fontWeight = FontWeight.Bold
//            )
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(10.dp)
//        ) {
//            Text(text = "Name", fontSize = 28.sp,modifier = Modifier.padding(16.dp))
//            Text(text = "Correct Answers", fontSize = 28.sp,modifier = Modifier.padding(16.dp))
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//
//        LazyColumn {
//            items(allUserScores.size) { i ->
//                Row(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color.White),
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically,
//                ) {
//                    Text(
//                        text = allUserScores[i].name,
//                        modifier = Modifier.padding(16.dp),
//                        fontSize = 24.sp
//                    )
//                    Text(
//                        text = "${allUserScores[i].correctAnswers}",
//                        modifier = Modifier.padding(16.dp),
//                        fontSize = 24.sp
//                    )
//                }
//            }
//        }
//    }
}

