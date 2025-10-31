package com.example.btuan4.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.btuan4.repository.TaskRepository
import com.example.btuan4.ui.screens.TaskDetailScreen
import com.example.btuan4.ui.screens.TaskListScreen
import com.example.btuan4.viewmodel.TaskDetailViewModel
import com.example.btuan4.viewmodel.TaskListViewModel
import com.example.btuan4.viewmodel.TaskViewModelFactory // Import Factory mới

// Đã đổi tên navHostController thành nav để phù hợp với code bên dưới
@Composable
fun NavGraph(navHostController: androidx.navigation.NavHostController? = null, repo: TaskRepository) {
    val nav = navHostController ?: rememberNavController()

    // Khởi tạo Factory chỉ một lần
    val factory = TaskViewModelFactory(repo)

    NavHost(navController = nav, startDestination = "task_list") {

        composable("task_list") {
            // SỬA: Sử dụng hàm viewModel() và Factory để tiêm repo
            val listVM: TaskListViewModel = viewModel(factory = factory)

            TaskListScreen(
                viewModel = listVM,
                // SỬA: onTaskClick phải nhận taskId và truyền nó
                onTaskClick = { taskId ->
                    nav.navigate("task_detail/$taskId")
                }
            )
        }

        // SỬA: Định nghĩa đường dẫn với tham số bắt buộc là {taskId}
        composable(
            route = "task_detail/{taskId}",
            arguments = listOf(navArgument("taskId") { type = NavType.IntType })
        ) { backStackEntry ->
            // Lấy taskId từ backStackEntry
            val taskId = backStackEntry.arguments?.getInt("taskId") ?: -1

            // SỬA: Sử dụng hàm viewModel() và Factory để tiêm repo
            val detailVM: TaskDetailViewModel = viewModel(factory = factory)

            TaskDetailScreen(
                taskId = taskId, // Truyền taskId vào màn hình
                viewModel = detailVM,
                onDeleted = {
                    // Sau khi delete, quay lại màn hình danh sách
                    nav.popBackStack()
                    // Gửi tín hiệu refresh đến TaskListScreen (nếu cần)
                    nav.currentBackStackEntry?.savedStateHandle?.set("refresh", true)
                }
            )
        }
    }
}