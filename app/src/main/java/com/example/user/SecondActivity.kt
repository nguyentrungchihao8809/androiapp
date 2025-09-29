package com.example.user

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                SecondScreen()
            }
        }
    }
}

@Composable
fun SecondScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("Nguyễn Trung Chí Hào") }
    var birth by remember {mutableStateOf("03/08/2005")}
    var address by remember {mutableStateOf("Quận 12, Hồ Chí Minh")}
    var town by remember {mutableStateOf("Vĩnh Long")}
    var school by remember {mutableStateOf("Đại học GTVT tp.HCM")}
    var It by remember {mutableStateOf("Công Nghệ thông Tin")}

    Box {

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
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                }
        )

        Text(text = "Họ Tên:",
            modifier = Modifier
            .padding(top=125.dp, start = 60.dp)
        )

        TextField(
            value = name,
            onValueChange = { newValue ->
                name = newValue
            },
            modifier = Modifier
                .padding(top = 150.dp, start = 60.dp)
        )

        Text(text = "Ngày sinh:" ,
            modifier = Modifier
                .padding(top = 225.dp, start = 60.dp)
                )
        TextField(
            value = birth,
            onValueChange = { newValue ->
                birth = newValue
            },
            modifier = Modifier
                .padding(top = 250.dp, start = 60.dp)
        )

        Text(text = "Địa chỉ:",
            modifier = Modifier
                .padding(top = 325.dp, start = 60.dp)
        )
        TextField(
            value = address,
            onValueChange = { newValue ->
                address = newValue
            },
            modifier = Modifier
                .padding(top = 350.dp, start = 60.dp)
        )

        Text(text = "Quê quán:",
            modifier = Modifier
                .padding(start = 60.dp, top = 425.dp)
            )
        TextField(
            value = town,
            onValueChange = { newValue ->
                town = newValue
            },
            modifier = Modifier
                .padding(top = 450.dp, start = 60.dp)
        )

        Text(text = "Trường học hiện tại:",
            modifier = Modifier
                .padding(top = 525.dp, start = 60.dp)
        )
        TextField(
            value = school,
            onValueChange = { newValue ->
                school = newValue
            },
            modifier = Modifier
                .padding(top = 550.dp, start = 60.dp)
        )

        Text(text = "Chuyên Ngành:",
            modifier = Modifier
                .padding(start = 60.dp, top = 625.dp)
            )
        TextField(
            value = It,
            onValueChange = { newValue ->
                It = newValue
            },
            modifier = Modifier
                .padding(top = 650.dp, start = 60.dp)
        )

    }
}
