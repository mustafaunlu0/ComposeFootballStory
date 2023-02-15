package com.mustafaunlu.composefootballstory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import com.plcoding.meditationuiyoutube.ui.theme.ComposeFootballStory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFootballStory {
                HomeScreen()

            }
        }
    }
}

