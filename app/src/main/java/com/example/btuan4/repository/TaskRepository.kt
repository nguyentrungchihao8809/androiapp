package com.example.btuan4.repository

import com.example.btuan4.models.Task
import com.example.btuan4.models.TaskListResponse
import com.example.btuan4.network.TaskApiService
import retrofit2.Response

class TaskRepository(private val api: TaskApiService) {

    suspend fun getTasks(): Response<TaskListResponse> = api.getTasks()

    // Đã sửa: Phải truyền taskId để TaskApiService có thể gọi đúng endpoint
    suspend fun getTask(taskId: Int): Response<Task> = api.getTask(taskId)

    // Đã sửa: Phải truyền taskId để TaskApiService có thể gọi đúng endpoint
    suspend fun deleteTask(taskId: Int): Response<Unit> = api.deleteTask(taskId)
}