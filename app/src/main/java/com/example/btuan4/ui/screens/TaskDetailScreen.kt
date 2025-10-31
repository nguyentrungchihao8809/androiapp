package com.example.btuan4.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import com.example.btuan4.models.Task
import com.example.btuan4.viewmodel.DetailState
import com.example.btuan4.viewmodel.TaskDetailViewModel
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDetailScreen(
    taskId: Int, // ĐÃ SỬA: Phải nhận ID của Task cần hiển thị
    viewModel: TaskDetailViewModel,
    onDeleted: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    // ĐÃ SỬA: Gọi loadTask và truyền taskId
    LaunchedEffect(taskId) {
        viewModel.loadTask(taskId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Task ID: $taskId") },
                actions = {
                    IconButton(
                        // ĐÃ SỬA: Gọi deleteTask và truyền taskId
                        onClick = { viewModel.deleteTask(taskId) }
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (state) {
                is DetailState.Loading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                is DetailState.Error -> Text(
                    text = (state as DetailState.Error).msg,
                    modifier = Modifier.align(Alignment.Center)
                )
                is DetailState.Success -> DetailContent((state as DetailState.Success).task)
                // Đảm bảo onDeleted chỉ được gọi một lần
                is DetailState.Deleted -> LaunchedEffect(Unit) { onDeleted() }
            }
        }
    }
}

@Composable
fun DetailContent(task: Task) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        item {
            // Tiêu đề và Mô tả
            Text(task.title, style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(6.dp))
            task.description?.let { Text(it, style = MaterialTheme.typography.bodyMedium) }
            Spacer(Modifier.height(12.dp))

            // Thông tin cơ bản
            Row {
                Text("Category: ${task.category ?: "N/A"}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.weight(1f))
                Text("Status: ${task.status ?: "N/A"}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.weight(1f))
            }
            Spacer(Modifier.height(8.dp))
            Text("Priority: ${task.priority ?: "N/A"}", style = MaterialTheme.typography.bodySmall)

            // Subtasks Header
            Spacer(Modifier.height(12.dp))
            Text("Subtasks (${task.subtasks.size})", style = MaterialTheme.typography.titleMedium)
        }

        items(task.subtasks.orEmpty()) { st ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Checkbox chỉ hiển thị trạng thái (onCheckedChange = null)
                Checkbox(checked = st.completed, onCheckedChange = null)
                Spacer(Modifier.width(8.dp))
                Text(st.title)
            }
        }

        // Attachments Header
        item {
            Spacer(Modifier.height(12.dp));
            Text("Attachments (${task.attachments.size})", style = MaterialTheme.typography.titleMedium)
        }

        items(task.attachments.orEmpty()) { att ->
            ListItem(headlineContent = { Text(att.name) })
        }

        item { Spacer(Modifier.height(32.dp)) } // Padding cuối
    }
}