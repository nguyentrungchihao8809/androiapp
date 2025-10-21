package com.example.baitaptuan4.ui.gd

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.material3.Divider
import androidx.compose.foundation.clickable
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.baitaptuan4.data.SachViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.border
import androidx.compose.foundation.lazy.items
import com.example.baitaptuan4.data.SinhVienViewModel

@Composable
fun QuanLyThuVienScreen(navController: androidx.navigation.NavHostController,  sachViewModel: SachViewModel, sinhvienViewModel: SinhVienViewModel) {
    var text by remember { mutableStateOf("") }
    val sinhVienList = sinhvienViewModel.sinhvienList
    Box() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Hệ Thống",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 40.dp)
            )
            Text(
                "Quản lý Thư viện",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 20.dp)
        ) {
            Text(
                "Sinh viên",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 200.dp)
            )
            Row() {
                LazyColumn(
                    modifier = Modifier
                        .width(230.dp)
                        .height(60.dp)
                        .background(Color(0xFFD3D3D3), shape = RoundedCornerShape(16.dp))
                        .padding(start = 5.dp)
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
                Button(
                    onClick = {navController.navigate("SinhVien")},
                    shape = RoundedCornerShape(17.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                    ),
                    modifier = Modifier
                        .width(125.dp)
                        .height(65.dp)
                        .padding(start = 20.dp, top = 5.dp)
                ) {
                    Text("Thay đổi") // Text hiển thị trên Button
                }
            }
//            Column(
//                modifier = Modifier
//                    .width(370.dp)
//                    .height(300.dp)
//                    .background(
//                        Color(0xFFD3D3D3),
//                        shape = RoundedCornerShape(16.dp)
//                    )
//            ) {
//                LazyColumn(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(300.dp)
//                        .background(Color(0xFFD3D3D3), shape = RoundedCornerShape(16.dp))
//                        .padding(8.dp)
//                ) {
//                    items(sachViewModel.sachList) { name ->
//                        Text(
//                            text = name,
//                            fontSize = 18.sp,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(vertical = 4.dp)
//                                .background(Color.White, shape = RoundedCornerShape(8.dp))
//                                .padding(8.dp)
//                        )
//                    }
//                }
            Column(
                modifier = Modifier
                    .padding(start = 5.dp, top = 50.dp)
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
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Button(
                        onClick = { navController.navigate("ThemSach")},
                        shape = RoundedCornerShape(17.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue,
                        ),
                        modifier = Modifier
                            .width(165.dp)
                            .height(80.dp)
                            .padding(top = 20.dp)
                    ) {
                        Text("Thêm")
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
