package com.example.user

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.withStyle
import coil.compose.AsyncImage
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue


class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface() {
                TextFieldScreen()
            }
        }
    }
}
@Composable
fun  TextFieldScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val context = LocalContext.current
    var password by remember { mutableStateOf(TextFieldValue("")) }
    Box() {
        Text("TextField",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            modifier = Modifier
                .padding(start = 130.dp, top = 30.dp)
            )
        Image(
            painter = painterResource(id = R.drawable.quaylai),
            contentDescription = "Arrow Back",
            modifier = Modifier
                .offset(x = 15.dp, y = (20) .dp)
                .size(48.dp)
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(8.dp)
                .clickable{
                    val intent = Intent(context, UiComActivity::class.java)
                    context.startActivity(intent)
                }
        )
        OutlinedTextField(
            value = password ,
            onValueChange = { password = it },
            label = { Text("thông tin đăng nhập") },
            singleLine = true,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top =200.dp, end = 20.dp)
        )
    }
}

