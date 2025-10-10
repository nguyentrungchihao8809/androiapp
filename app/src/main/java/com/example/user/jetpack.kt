package com.example.jetpack

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.user.R
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.platform.LocalContext
import com.example.user.UiComActivity


@Composable
fun uijetpack(modifier: Modifier = Modifier.fillMaxSize()) {
    var isBold by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Box() {
        Image(
            painter = painterResource(id = R.drawable.jetpack),
            contentDescription = "Ảnh đại diện",
            contentScale = ContentScale.Crop, //hiển thị khác kích thước ảnh gôc
            modifier = Modifier
                .padding(start = 90.dp, top = 100.dp)
                .size(230.dp)
                .clip(CircleShape)
        )
        Text("Jetpack Compose",
            modifier = Modifier
                .padding(start = 140.dp, top = 350.dp)
        )
        Column {
            Text("Jectpack Compose is a modern UI toolkit for buiding native Androi application using a declarative programming approach",
               textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .padding(top = 400.dp)
            )
        }

        Button(
            onClick = {
                val intent = Intent(context, UiComActivity::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4ABDE0)),
                modifier = Modifier
                .padding(start = 60.dp, top = 800.dp)
                .width(300.dp)
                .height(50.dp)
        ) {
            Text("I'm readly")
        }
    }

}