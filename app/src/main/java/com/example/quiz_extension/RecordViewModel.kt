package com.example.quiz_extension

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quiz_extension.api.QuizItem
import com.example.quiz_extension.api.QuizService
import com.example.quiz_extension.data.Record
import com.example.quiz_extension.data.RecordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultsViewModel(private var repository : RecordRepository) : ViewModel() {



    private val _quizQuestions = MutableStateFlow<List<QuizItem>>(emptyList())
    val quizQuestions: StateFlow<List<QuizItem>> = _quizQuestions

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://the-trivia-api.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val quizService = retrofit.create(QuizService::class.java)


    fun getRandomQuestions() {
        viewModelScope.launch {
            try {
                val response = quizService.getQuestions()
                _quizQuestions.value = response.results
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }







    var name by mutableStateOf("")
    var correctAnswers by mutableIntStateOf(0)


     val getAllRecords : Flow<List<Record>> = repository.getRecords


    suspend fun saveUserScore(userName : String ,score : Int) {
        repository.insertRecords(
           Record(
               name = userName,
               correctAnswers = score
           )
        )
    }
}