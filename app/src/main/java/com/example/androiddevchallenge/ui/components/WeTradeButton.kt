package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun WeTradeButton(
    title: String,
    modifier: Modifier,
    onClickAction: () -> Unit
) {
    Button(onClick = onClickAction, modifier = modifier, shape = CircleShape) {
        Text(text = title)
    }
}

@Composable
fun OutlinedWeTradeButton(
    title: String,
    modifier: Modifier,
    border: BorderStroke,
    onClickAction: () -> Unit
) {
    OutlinedButton(onClick = onClickAction, modifier = modifier, shape = CircleShape, border = border, colors = ButtonDefaults.outlinedButtonColors(
        Color.Transparent)) {
        Text(text = title, style = MaterialTheme.typography.button)
    }
}