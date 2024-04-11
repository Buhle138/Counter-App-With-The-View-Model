package com.example.composepracticewiithkat

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var state = mutableStateOf(Counter())

    fun increaseCounter(){
        state.value = state.value.copy(count = state.value.count + 1)
    }

    fun decreaseCounter(){
        state.value = state.value.copy(count = state.value.count - 1)
    }

}