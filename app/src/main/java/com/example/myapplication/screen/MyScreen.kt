package com.example.myapplication.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.myapplication.Constants
import com.example.myapplication.components.ButtonWrap
import com.example.myapplication.components.Squares

@Composable
fun MyScreen() {
    var count by rememberSaveable { mutableStateOf(Constants.START_COUNT_SQUARES) }
    Squares(count)
    ButtonWrap({count++})
}