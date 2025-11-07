package com.example.myapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.example.myapplication.Constants
import com.example.myapplication.R

@Composable
fun Square(
    item: Int
) {
    Box(
        modifier = Modifier
            .aspectRatio(Constants.ASPECT_RATIO_SQUARE)
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
            fontSize = Constants.SQUARES_TEXT_SIZE,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}