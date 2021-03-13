package com.example.androiddevchallenge.ui.components.welcome

import android.service.autofill.OnClickAction
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.MyApp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.ui.components.OutlinedWeTradeButton
import com.example.androiddevchallenge.ui.components.WeTradeButton

@Composable
fun WelcomeContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_welcome_bg),
            contentDescription = "WeTrade Background",
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "WeTrade Logo",
            modifier = Modifier.align(
                Alignment.Center
            )
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp, 16.dp, 16.dp, 32.dp)
        ) {
            WeTradeButton(
                title = stringResource(id = R.string.welcome_get_started),
                modifier = Modifier
                    .height(48.dp)
                    .weight(1f),
                onClickAction = { /*TODO*/ })
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedWeTradeButton(
                title = stringResource(id = R.string.welcome_log_in),
                modifier = Modifier.height(48.dp).weight(1f),
                border = BorderStroke(1.dp, Color.Yellow),
                onClickAction = { /*TODO*/ })
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        WelcomeContent()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomeContent()
    }
}