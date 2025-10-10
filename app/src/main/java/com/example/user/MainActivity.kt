package com.example.user

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import android.content.Intent
import androidx.compose.ui.platform.LocalContext
import com.example.jetpack.uijetpack


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                uijetpack()
        }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier.fillMaxSize()) {
    val context = LocalContext.current
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {

        Text(
            text = "Nguyễn Trung Chí Hào",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 440.dp)
        )
        Text(
            text = "Hồ Chí Minh, Việt Nam",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 420.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "Ảnh đại diện",
            contentScale = ContentScale.Crop, //hiển thị khác kích thước ảnh gôc
            modifier = Modifier
                .offset(y = (-150) .dp)
                .align(Alignment.Center)
                .size(230.dp)
                .clip(CircleShape)
                .clickable{
                    val intent = Intent(context, SecondActivity::class.java)
                    context.startActivity(intent)
                }
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
        )
        Image(
            painter = painterResource(id = R.drawable.cayviet),
            contentDescription = "Edit Document",
            modifier = Modifier
                .offset(x = (-15).dp, y = (20) .dp)
                .size(50.dp)
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(10.dp) // viền vuông bo góc nhẹ
                )
                .padding(8.dp)
                .align(Alignment.TopEnd)
                .clickable {
                    val intent = Intent(context, SecondActivity::class.java)
                    context.startActivity(intent)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        Greeting()
    }
}
