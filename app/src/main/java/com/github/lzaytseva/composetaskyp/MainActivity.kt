package com.github.lzaytseva.composetaskyp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.lzaytseva.composetaskyp.ui.theme.ComposeTaskYPTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTaskYPTheme {
                ContactDetailsScreen()
            }
        }
    }
}

