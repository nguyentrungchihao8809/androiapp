package com.example.BTtrenclass

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.user.R
import com.example.user.UiComActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            trenclass()
        }
    }
}

@Composable
fun trenclass(modifier: Modifier = Modifier.fillMaxSize()) {
    var isBold by remember { mutableStateOf(false) }
    Box() {
        Text("MyfirtApp",
            modifier = Modifier
                .padding(start = 155.dp, top = 200.dp)
        )
        Text("I'm",
            modifier = Modifier
                .padding(start = 185.dp, top = 400.dp)
        )
        Text("NGUYEN TRUNG CHI HAO",
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
            modifier = Modifier
                .padding(start = 100.dp, top = 420.dp)
        )
        Button(
            onClick = { isBold = true },
            modifier = Modifier.padding(start = 150.dp, top = 550.dp)
        ) {
            Text("Say Hi!")
        }
    }

}