package com.example.btuan4.network

import com.example.btuan4.models.Task
import com.example.btuan4.models.TaskListResponse
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path // Cần thiết để truyền ID vào URL

interface TaskApiService {

    // 1. Lấy danh sách tất cả task
    // Endpoint: GET /tasks
    @GET("tasks")
    suspend fun getTasks(): Response<TaskListResponse>

    // 2. Lấy task duy nhất (SỬA: Sử dụng @Path để truyền ID động)
    // Endpoint: GET /tasks/{id}
    @GET("tasks/{id}") // Giả sử endpoint là /tasks/{id}
    suspend fun getTask(
        @Path("id") taskId: Int // Truyền ID của task cần lấy
    ): Response<Task>

    // 3. Xóa task duy nhất (SỬA: Sử dụng @Path để truyền ID động)
    // Endpoint: DELETE /tasks/{id}
    @DELETE("tasks/{id}") // Giả sử endpoint là /tasks/{id}
    suspend fun deleteTask(
        @Path("id") taskId: Int // Truyền ID của task cần xóa
    ): Response<Unit>

    // Ghi chú: Nếu API của bạn có endpoint là "task/1" (số ít), hãy thay "tasks/{id}"
    // bằng "task/{id}". Nhưng chuẩn RESTful thường dùng "tasks/{id}".
}