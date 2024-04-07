package com.example.quiz_extension

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.quiz_extension.data.RecordDatabase
import com.example.quiz_extension.data.RecordRepository
import com.example.quiz_extension.ui.theme.Quiz_ExtensionTheme

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Quiz_ExtensionTheme {

                val appContext = LocalContext.current.applicationContext
                val db = Room.databaseBuilder(
                    appContext,
                    RecordDatabase::class.java, "record_database.db"
                ).build()
                val userScoreDao = db.recordDao()
                val repository = RecordRepository(userScoreDao)

                val viewModel by viewModels<ResultsViewModel>(
                    factoryProducer = {
                        object : ViewModelProvider.Factory {
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                return ResultsViewModel(repository = repository) as T
                            }
                        }
                    }
                )

                val allUserScores by viewModel.getAllRecords.collectAsState(initial = emptyList())
                Navigation(
                    viewModel = viewModel,
                    allUserScores = allUserScores
                )
            }
        }
    }
}

