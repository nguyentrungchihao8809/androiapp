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


class RowLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface() {
                RowLayoutScreen()
            }
        }
    }
}
@Composable
fun  RowLayoutScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box() {
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
            Text(
                "Row Layout",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier
                    .padding(start = 110.dp, top = 30.dp)
            )
        }
        repeat(4) { // 4 hàng
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(3) { column ->
                    val color = if (column == 1)
                        Color(0xFF4285F4) // Màu xanh đậm ô giữa
                    else
                        Color(0xFF90CAF9) // Màu xanh nhạt ô ngoài

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(2f) // Chiều rộng gấp đôi chiều cao
                            .clip(RoundedCornerShape(16.dp))
                            .background(color)
                    )
                }
            }
        }
    }
}

