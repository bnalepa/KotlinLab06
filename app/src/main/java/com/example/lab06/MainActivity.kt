package com.example.lab06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab06.ui.theme.Lab06Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab06Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var counterState by remember {
        mutableStateOf(0)
    }
    var switchState by remember {
        mutableStateOf(false)
    }
    var editState by remember {
        mutableStateOf("ABC")
    }
    Column(modifier = modifier) {

    Text(
        text = "Hello $name!",
        modifier = modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally),
        textAlign = TextAlign.Center
    )
    FilledTonalButton(
        modifier = modifier
            .align(Alignment.CenterHorizontally),
        onClick = {counterState++}) {
        Text("Click $counterState")
    }
    Switch(checked = switchState ,
        onCheckedChange = {switchState = !switchState})

    TextField(value = editState, onValueChange = {
        editState = it
    },
        modifier= modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab06Theme {
        Greeting("Android", Modifier.background(Color.Green))
    }
}