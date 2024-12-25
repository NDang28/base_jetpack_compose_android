package com.example.jetpackapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackapp.ui.theme.JetpackAppTheme
import com.example.jetpackapp.widget.Button.Button
import com.example.jetpackapp.widget.Button.ElevatedButton
import com.example.jetpackapp.widget.Button.IconButton
import com.example.jetpackapp.widget.Button.LoadingButton
import com.example.jetpackapp.widget.Button.OutlineButton
import kotlinx.coroutines.delay
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Greeting(
                            name = "Android"
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            width = 100.dp,
                            height = 40.dp,
                            text = "Button",
                            backgroundColor = Color.Green
                        ) {
                            Toast.makeText(this@MainActivity, "Button Click", Toast.LENGTH_SHORT)
                                .show()
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        OutlineButton(
                            width = 150.dp,
                            height = 40.dp,
                            backgroundColor = Color.Blue,
                            borderColor = Color.Black,
                            text = "Outline Button",
                            borderWidth = 1.dp,
                        ) {
                            Toast.makeText(
                                this@MainActivity,
                                "Outline Button Click",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        IconButton(
                            width = 150.dp,
                            height = 40.dp,
                            text = "Icon Button",
                            backgroundColor = Color.Red,
                            icon = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground)
                        ) {
                            Toast.makeText(
                                this@MainActivity,
                                "Icon Button Click",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        ElevatedButton(
                            width = 150.dp,
                            height = 40.dp,
                            text = "Elevated Button",
                            backgroundColor = Color.Yellow,
                            elevation = 8.dp
                        ) {
                            Toast.makeText(
                                this@MainActivity,
                                "Elevated Button Click",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        LoadingButton(
                            width = 200.dp,
                            height = 50.dp,
                            text = "Click Me!",
                            backgroundColor = Color.LightGray,
                            onClick = suspend {
                                // Mô phỏng loading
                                delay(Random.nextLong(1000, 3000))
                                println("Loading done!")
                            }
                        )


                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", style = MaterialTheme.typography.headlineLarge,
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetpackAppTheme {
        Greeting("Android")
    }
}