package com.example.myapplication.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.myapplication.Constants
import com.example.myapplication.R

@Composable
fun AddButton(
    onClick: () -> Unit,
){
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(dimensionResource(R.dimen.size_rounded_corner_button)),
        colors = ButtonDefaults.buttonColors(colorResource(R.color.button_color)),
        modifier = Modifier
            .size(dimensionResource(R.dimen.button_size))
            .aspectRatio(Constants.ASPECT_RATIO_BUTTON)
    ) {
        Text(
            text = stringResource(R.string.button_text),
            color = colorResource(R.color.text_button_color),
            fontSize = Constants.BUTTON_TEXT_SIZE,
        )
    }
}