package com.example.baitaptuan4.ui.gd

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavHostController
import com.example.baitaptuan4.data.SinhVienViewModel

@Composable
fun SinhVienScreen(navController: NavHostController, sinhvienViewModel: SinhVienViewModel) {
    var nameInput by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Thêm sinh viên",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 40.dp, bottom = 40.dp)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    value = nameInput,
                    onValueChange = { nameInput = it },
                    label = { Text("Nhập tên sinh viên") },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.width(250.dp)
                )

                Button(
                    onClick = {
                        sinhvienViewModel.themSinhVien(nameInput)
                        nameInput = ""
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5)),
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .height(55.dp)
                ) {
                    Text("Thêm")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Danh sách sinh viên:",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.Start)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(16.dp))
            ) {
                items(sinhvienViewModel.sinhvienList) { name ->
                    Text(
                        text = name,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                }
            }
        }

        // Thanh điều hướng
        Divider(
            color = Color.LightGray,
            thickness = 4.dp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 70.dp)
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Quản lý",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .clickable { navController.navigate("QuanLyThuVien") }
            )
            Text(
                "DS Sách",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .clickable { navController.navigate("ThemSach") }
            )
            Text(
                "Sinh viên",
                fontSize = 20.sp,
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
}
