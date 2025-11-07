package com.example.myapplication.components

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import com.example.myapplication.Constants
import com.example.myapplication.R

@Composable
fun Squares (
    count: Int,
) {
    val list = List(count) { it + 1 }
    val countColumn = if (LocalConfiguration.current.orientation ==  ORIENTATION_PORTRAIT)
                            Constants.PORTRAIT_COLUMNS
                        else Constants.LANDSCAPE_COLUMNS
    LazyVerticalGrid(
        columns = GridCells.Fixed(countColumn),
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(bottom =
            (dimensionResource(R.dimen.standart_padding) * 2 +
                    dimensionResource(R.dimen.button_size)))
    ) {
        items (items = list){
                item -> Square(item)
        }
    }
    }