//// com/example/btuan4/MainActivity.kt
//package com.example.btuan4
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.runtime.*
//import com.example.btuan4.ui.HomeScreen
//import com.example.btuan4.ui.SignInScreen
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//import com.example.btuan4.ui.ProductScreen
//
//class MainActivity : ComponentActivity() {
//
//    private lateinit var auth: FirebaseAuth
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        auth = FirebaseAuth.getInstance()
//
//        setContent {
//            // Bắt đầu ứng dụng với AuthApp để theo dõi trạng thái đăng nhập
//            AuthApp(auth = auth)
//        }
//    }
//}
//
//@Composable
//fun AuthApp(auth: FirebaseAuth) {
//    // Giữ trạng thái người dùng hiện tại
//    var user by remember { mutableStateOf<FirebaseUser?>(auth.currentUser) }
//
//    // Lắng nghe sự thay đổi trạng thái xác thực
//    DisposableEffect(auth) {
//        val authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
//            user = firebaseAuth.currentUser
//        }
//        auth.addAuthStateListener(authStateListener)
//        onDispose {
//            auth.removeAuthStateListener(authStateListener)
//        }
//    }
//
//    // Điều hướng dựa trên trạng thái đăng nhập
//    if (user != null) {
//        // Đã đăng nhập → Mở HomeScreen
//        HomeScreen(
//            onSignOut = {
//                auth.signOut() // Khi đăng xuất, user sẽ tự động thành null
//            }
//        )
//    } else {
//        // Chưa đăng nhập → Mở SignInScreen
//        SignInScreen()
//    }
//}

package com.example.btuan4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.rememberNavController
import com.example.btuan4.ui.NavGraph
import com.example.btuan4.network.RetrofitClient
import com.example.btuan4.repository.TaskRepository
import com.example.btuan4.viewmodel.TaskDetailViewModel
import com.example.btuan4.viewmodel.TaskListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repo = TaskRepository(RetrofitClient.apiService)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                // Pass repo-created ViewModels by factory or simple creation
                NavGraph(navController = navController, repo = repo)
            }
        }
    }
}

