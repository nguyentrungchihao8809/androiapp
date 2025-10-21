package com.example.baitaptuan4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baitaptuan4.ui.gd.QuanLyThuVienScreen
import com.example.baitaptuan4.ui.gd.SinhVienScreen
import com.example.baitaptuan4.ui.gd.ThemSachScreen
import com.example.baitaptuan4.data.SachViewModel
import com.example.baitaptuan4.data.SinhVienViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val sachViewModel: SachViewModel = viewModel()
            val sinhvienViewModel: SinhVienViewModel = viewModel()

            NavHost(
                navController = navController,
                startDestination = "QuanLyThuVien"
            ) {
                composable("QuanLyThuVien") {QuanLyThuVienScreen(navController, sachViewModel, sinhvienViewModel) }
                composable("SinhVien") {SinhVienScreen(navController, sinhvienViewModel)}
                composable("ThemSach") {ThemSachScreen(navController, sachViewModel )}
            }
        }
    }
}



