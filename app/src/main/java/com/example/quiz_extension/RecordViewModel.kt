package com.example.quiz_extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencycon.api.NetworkResponse
import com.example.currencycon.api.RetrofitInstance
import com.example.currencycon.api.Trivia
import kotlinx.coroutines.launch

class ResultsViewModel() : ViewModel() {



    private val triviaApi = RetrofitInstance.triviaApi
    private val _triviaResult = MutableLiveData<NetworkResponse<Trivia>>()
    val triviaResult: LiveData<NetworkResponse<Trivia>> = _triviaResult

    fun getData(amount: Int) {
        _triviaResult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try{
                val response = triviaApi.getQuestions(amount)
                if (response.isSuccessful) {
                    _triviaResult.value = NetworkResponse.Success(response.body()!!)
                }else{
                    _triviaResult.value = NetworkResponse.Error("Error to load data")
                }
            } catch (e: Exception){
                _triviaResult.value = NetworkResponse.Error("Error in load data")
            }
        }
    }

}