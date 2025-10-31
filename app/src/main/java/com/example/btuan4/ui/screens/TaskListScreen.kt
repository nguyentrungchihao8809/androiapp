package com.example.btuan4.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
// Cần thiết để sử dụng Icons.Default.Checkbox
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.* // Giữ nguyên để tận dụng các Composable khác
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.btuan4.models.Task
import com.example.btuan4.viewmodel.TaskListViewModel
import com.example.btuan4.viewmodel.UiState
import kotlinx.coroutines.flow.collectLatest

// *** THÊM IMPORT VÀ OPT-IN ĐỂ KHẮC PHỤC LỖI TỪ MATERIAL 3 ***
import androidx.compose.material3.ExperimentalMaterial3Api
// Dòng Icons.Default.Info không cần thiết, tôi đã xoá để code sạch hơn
// **********************************************************


@OptIn(ExperimentalMaterial3Api::class) // Khắc phục cảnh báo TopAppBar
@Composable
fun TaskListScreen(
    viewModel: TaskListViewModel,
    onTaskClick: (Int) -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    // Fetch tasks when screen enters
    LaunchedEffect(Unit) { viewModel.fetchTasks() }

    Scaffold(
        topBar = {
            // Đã thay thế SmallTopAppBar bằng TopAppBar
            TopAppBar(title = { Text("List") })
        }
    ) { padding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(padding)) {
            when (state) {
                is UiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is UiState.Empty -> {
                    EmptyView()
                }
                is UiState.Error -> {
                    Text((state as UiState.Error).message, modifier = Modifier.align(Alignment.Center))
                }
                is UiState.Success -> {
                    TaskList((state as UiState.Success).tasks, onTaskClick)
                }
            }
        }
    }
}

@Composable
fun EmptyView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Cú pháp Icon đã được sửa lỗi
        Icon(Icons.Default.Info, contentDescription = null, modifier = Modifier.size(64.dp))
        Spacer(Modifier.height(12.dp))
        Text("No Tasks Yet!", style = MaterialTheme.typography.titleMedium)
        Text("Stay productive — add something to do", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun TaskList(tasks: List<Task>, onTaskClick: (Int) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(8.dp)) {
        items(tasks) { task ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
                .clickable { task.id?.let { onTaskClick(it) } }
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(task.title, style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(4.dp))
                    Text(task.description ?: "", style = MaterialTheme.typography.bodySmall)
                    Spacer(Modifier.height(6.dp))
                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                        Text(task.status ?: "", style = MaterialTheme.typography.labelSmall)
                        Text(task.priority ?: "", style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        }
    }
}