
package com.example.btuan4.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.btuan4.R
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen() {
    val currentUser = FirebaseAuth.getInstance().currentUser
    Column() {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = "anh uth",
                modifier = Modifier
                    .size(80.dp)
                    .padding(top = 40.dp)
            )
            Text("Product detail",
                fontSize = 30.sp,
                color = Color(0xFF2196F3),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 40.dp, start = 130.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.giay),
            contentDescription = "anh uth",
            modifier = Modifier
                .size(400.dp)
                .padding(top = 40.dp, start = 15.dp)
                .clip(RoundedCornerShape(30.dp))
        )

        Text("Giày Nike Nam Nữ Chính Hãng - Nike Air Force 1",
            modifier = Modifier
                .padding(top = 40.dp, start = 25.dp))
        Text("07 LV8-Màu Trắng | JapanSport HF2898-100",
            modifier = Modifier
                .padding(start = 25.dp))

    }
}
