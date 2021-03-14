package com.example.androiddevchallenge.model

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class Position(val ticker: String, val companyName: String, val price: Float, val percentChange: Float, val chart: Int)