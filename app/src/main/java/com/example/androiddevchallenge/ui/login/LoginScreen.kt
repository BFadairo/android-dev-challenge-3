package com.example.androiddevchallenge.ui.login

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.components.WeTradeButton
import java.time.format.TextStyle


@Composable
fun LoginScreen() {
    Surface(modifier = Modifier.background(Color.White)) {
        Column(modifier = Modifier.fillMaxSize()) {
            LoginContent()
        }
    }
}

@Composable
fun LoginContent() {
    Greeting()
    InfoInput()
}


@Composable
fun Greeting() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.ic_login_bg),
            contentDescription = "Login Background",
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(
                text = "Welcome back",
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.width(200.dp)
            )
        }
    }
}

@Composable
fun InfoInput() {
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    Spacer(modifier = Modifier.height(40.dp))
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = emailInput,
            onValueChange = { emailInput = it },
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Email Address") },
            leadingIcon = { Icon(Icons.Default.MailOutline, "Mail Outline") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = passwordInput,
            textStyle = MaterialTheme.typography.body1,
            onValueChange = { passwordInput = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Password") },
            leadingIcon = { Icon(Icons.Default.Password, "Password Icon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row() {
            WeTradeButton(title = stringResource(id = R.string.welcome_log_in),
                modifier = Modifier
                    .height(48.dp)
                    .weight(1f),
                onClickAction = { /*TODO*/ })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoInputPreview() {
    MyTheme {
        InfoInput()
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreview() {
    MyTheme {
        Surface() {
            LoginScreen()
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Surface() {
            LoginScreen()
        }
    }
}