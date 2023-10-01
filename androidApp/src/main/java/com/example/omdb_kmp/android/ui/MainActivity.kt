package com.example.omdb_kmp.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.omdb_kmp.android.theme.OMDbKmpTheme
import com.example.omdb_kmp.android.util.UltraPreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            OMDbKmpTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    GreetingView("Hello Pranit!")
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = text
    )
}

@UltraPreview
@Composable
fun DefaultPreview() {
    OMDbKmpTheme {
        GreetingView("Hello, Android!")
    }
}