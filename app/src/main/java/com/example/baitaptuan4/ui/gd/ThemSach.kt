package com.example.baitaptuan4.ui.gd

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import com.example.baitaptuan4.data.SachViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.baitaptuan4.data.Sach


@Composable
fun ThemSachScreen(navController: androidx.navigation.NavHostController, sachViewModel: SachViewModel) {
    var nameInput by remember { mutableStateOf("") }
    val nameList = remember { mutableStateListOf<String>() }
    Box() {
        Text(
            "Thêm sách",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 120.dp, top = 50.dp)
        )
        Row(
            modifier = Modifier
                .padding(start = 20.dp, top = 200.dp)
        ) {
            OutlinedTextField(
                value = nameInput,
                onValueChange = { nameInput = it },
                label = { Text("Nhập tên sách") },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(250.dp)
            )
            Button(
                onClick = {
                    if (nameInput.isNotBlank()) {
                        sachViewModel.sachList.add(Sach(nameInput)) // ✅ Đúng
                        nameInput = "" // xóa input sau khi thêm
                    }
                },
                shape = RoundedCornerShape(17.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                ),
                modifier = Modifier
                    .width(155.dp)
                    .height(60.dp)
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            ) {
                Text("Thêm")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .padding(start = 20.dp, top = 300.dp)
                .fillMaxWidth()
        ) {
            Text(
                "Danh sách sách",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .width(360.dp)
                    .height(200.dp)
                    .background(Color(0xFFD3D3D3), shape = RoundedCornerShape(16.dp))
                    .padding(8.dp)
            ) {
                items(sachViewModel.sachList) { sach ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    ) {
                        Checkbox(
                            checked = sach.isChecked,
                            onCheckedChange = { checked -> sach.isChecked = checked }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = sach.name)
                    }
                }
            }
        }


            Divider(
                color = Color.LightGray,
                thickness = 5.dp,
                modifier = Modifier
                    .padding(top = 780.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 820.dp)
            ) {
                Text(
                    "Quản lý",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .clickable {
                            navController.navigate("QuanLyThuVien")
                        },
                )
                Text(
                    "DS sách",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(start = 80.dp)
                        .clickable {
                            navController.navigate("ThemSach")
                        },
                )
                Text(
                    "Sinh viên",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(start = 70.dp)
                        .clickable {
                            navController.navigate("SinhVien")
                        },
                )
            }
        }
    }