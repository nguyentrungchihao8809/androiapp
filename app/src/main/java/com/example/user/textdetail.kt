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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.withStyle




class textdetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface() {
                TextScreen()
            }
        }
    }
}
@Composable
fun  TextScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val context = LocalContext.current
    Box() {
        Text(text = "Text Detail",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Blue,
            modifier = Modifier
                .padding(start = 120.dp, top = 30.dp)
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
                    shape = RoundedCornerShape(10.dp) // viền vuông bo góc nhẹ
                )
                .padding(8.dp)
                .clickable{
                val intent = Intent(context, UiComActivity::class.java)
                context.startActivity(intent)
            }
        )
        Text( text = buildAnnotatedString {
            append("The ")

            withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                append("quick ")
            }

            withStyle(
                style = SpanStyle(
                    color = Color(0xFF8B4513), // nâu
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Brown\n")
            }

            append("fox j u m p s ")

            withStyle(
                style = SpanStyle(
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("over\n")
            }

            append("the ")

            withStyle(
                style = SpanStyle(
                    fontStyle = FontStyle.Italic,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("lazy ")
            }

            append("dog.")
        },
            fontSize = 40.sp,
            lineHeight = 62.sp,
            modifier = Modifier.padding(start = 40.dp, top = 300.dp)
        )
    }
}

