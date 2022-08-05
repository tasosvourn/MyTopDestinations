package com.example.mytopdestinations.presentation.features

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.mytopdestinations.presentation.theme.MyTopDestinationsTheme
import com.example.mytopdestinations.presentation.features.topdestinations.TopDestinationsActivity

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTopDestinationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                    GetTopDestinations()
                }
            }
        }
       // startActivity(Intent(this, TopDestinationsActivity::class.java))
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun GetTopDestinations() {
    val context = LocalContext.current
    Button(onClick = { context.startActivity(Intent(context, TopDestinationsActivity::class.java)) }) {
        Text(text = "Find Destinations")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTopDestinationsTheme {
        Greeting("Android")
        GetTopDestinations()
    }
}