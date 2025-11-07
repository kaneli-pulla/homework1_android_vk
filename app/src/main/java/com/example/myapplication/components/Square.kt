package com.example.myapplication.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.Constants
import com.example.myapplication.R

@Composable
fun Square(
    item: Int,
) {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(
                context,
                "$item",
                Toast.LENGTH_SHORT
            ).show()
        },
        modifier = Modifier
            .aspectRatio(Constants.ASPECT_RATIO_SQUARE)
            .padding(dimensionResource(R.dimen.standart_padding)),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (item % 2 != 0)
                colorResource(R.color.blue_square_color)
            else
                colorResource(R.color.red_square_color)
        )
    ) {
    }
}