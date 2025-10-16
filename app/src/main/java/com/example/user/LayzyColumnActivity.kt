package com.example.user

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.remember
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items



class LayzyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface() {
                LayzyScreen()
            }
        }
    }
}

@Composable
fun LayzyScreen() {
    val arr = remember {
        List(1000000) { i -> "${i + 1} - dòng số ${i + 1}" }
    }

//    Column {
//        for (line in arr) {
//            Text(
//                text = line,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(4.dp)
//            )
//        }

    LazyColumn {
        items(arr) { line ->
            Text(
                text = line,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            )
        }
    }
}
