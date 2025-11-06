package com.example.myapplication

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MyScreen() {
    var count by rememberSaveable { mutableStateOf(0) }
    val list = List(count) { it + 1 }
    val countColumn = if (LocalConfiguration.current.orientation ==  ORIENTATION_PORTRAIT) 3 else 4
    LazyVerticalGrid(
        columns = GridCells.Fixed(countColumn),
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(bottom =
            (dimensionResource(R.dimen.standart_padding) * 2 +
                                dimensionResource(R.dimen.button_size)))
    ) {
        items ( list){
            item -> Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(dimensionResource(R.dimen.standart_padding))
                    .background(
                         if (item % 2 != 0)
                                    colorResource(R.color.blue_square_color)
                                else
                                    colorResource(R.color.red_square_color)),
            ) {
                Text(
                    text = "$item",
                    color = colorResource(R.color.text_square_color),
                    fontSize = dimensionResource(R.dimen.squares_text_size).value.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
        }
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(dimensionResource(R.dimen.standart_padding))
        ) {
            Button(
                onClick = { count += 1 },
                shape = RoundedCornerShape(dimensionResource(R.dimen.size_rounded_corner_button)),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.button_color)),
                modifier = Modifier
                    .size(dimensionResource(R.dimen.button_size))
                    .aspectRatio(1f)
            ) {
                Text(
                    text = stringResource(R.string.button_text),
                    color = colorResource(R.color.text_button_color),
                    fontSize = dimensionResource(R.dimen.button_text_size).value.sp,
                )
            }
        }
    }
}

