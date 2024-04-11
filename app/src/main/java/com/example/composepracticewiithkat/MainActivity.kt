package com.example.composepracticewiithkat

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.composepracticewiithkat.ui.theme.ComposePracticeWiithKatTheme

class MainActivity : ComponentActivity() {

    val myViewModel by lazy{
        ViewModelProvider(this).get(CounterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeWiithKatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyCounter(myViewModel)
                }
            }
        }
    }
}

@Composable
fun MyCounter(myViewModel: CounterViewModel){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row (
            modifier = Modifier.padding(horizontal = 80.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = {
                   myViewModel.increaseCounter()
                }) {
                Text("Add")
            }
            Button(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    myViewModel.decreaseCounter()
                }) {
                Text("Decrease")
            }
        }
        Text("Counting: ${myViewModel.state.value.count}")

    }


}