package com.example.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BaiThucHanh2(modifier: Modifier = Modifier.fillMaxSize()) {
    var input by remember { mutableStateOf("") }
    var errorMsg by remember { mutableStateOf("") }
    var count by remember { mutableStateOf(0) } // số lượng thẻ hiện tại

    Box(modifier = modifier) {

        Text(
            text = "Thực hành 02",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 300.dp)
        )

        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Nhập số (1-4)") },
            shape = RoundedCornerShape(50.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(start = 10.dp, top = 350.dp)
                .width(270.dp)
        )

        Button(
            onClick = {
                val num = input.toIntOrNull()
                if (num != null && num in 1..4) {
                    count = num
                    errorMsg = ""
                } else {
                    count = 0
                    errorMsg = "Chỉ nhập số từ 1 đến 4"
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3),
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(start = 290.dp, top = 360.dp)
        ) {
            Text("Xác nhận")
        }

        if (errorMsg.isNotEmpty()) {
            Text(
                text = errorMsg,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 170.dp)
            )
        }

        for (i in 1..count) {
            Box(
                modifier = Modifier
                    .padding(top = 230.dp)
                    .align(Alignment.TopCenter)
                    .padding(top = (200 + (i - 1) * 60).dp) // mỗi thẻ cách nhau 60dp
                    .fillMaxWidth(0.5f)
                    .height(50.dp)
                    .background(
                        color = Color(0xFFF44336),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$i",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
