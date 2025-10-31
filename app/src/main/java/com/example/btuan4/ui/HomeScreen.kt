// com/example/myapplication/ui/HomeScreen.kt
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onSignOut: () -> Unit) {
    val currentUser = FirebaseAuth.getInstance().currentUser

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Profile",
                        color = Color(0xFF0D47A1),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onSignOut() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF2196F3)
                )
            )
        },
        content = { paddingValues ->
            currentUser?.let { user ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(horizontal = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(24.dp))

                    Box(contentAlignment = Alignment.BottomEnd) {
                        Image(
                            painter = rememberAsyncImagePainter(user.photoUrl),
                            contentDescription = "Avatar",
                            modifier = Modifier
                                .size(110.dp)
                                .clip(CircleShape)
                        )

                        Icon(
                            imageVector = Icons.Default.CameraAlt,
                            contentDescription = "Change photo",
                            tint = Color(0xFF2196F3),
                            modifier = Modifier
                                .size(28.dp)
                                .background(Color.White, CircleShape)
                                .padding(4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Name
                    OutlinedTextField(
                        value = user.displayName ?: "",
                        onValueChange = {},
                        label = { Text("Name") },
                        readOnly = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Email
                    OutlinedTextField(
                        value = user.email ?: "",
                        onValueChange = {},
                        label = { Text("Email") },
                        readOnly = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Date of Birth (giá trị tĩnh minh hoạ)
                    OutlinedTextField(
                        value = "23/05/1995",
                        onValueChange = {},
                        label = { Text("Date of Birth") },
                        readOnly = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = onSignOut,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2196F3)
                        ),
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .width(180.dp)
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Back",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            } ?: run {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Đang tải thông tin người dùng...")
                }
            }
        }
    )
}
