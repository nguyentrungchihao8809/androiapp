package com.example.btuan4.models

import com.google.gson.annotations.SerializedName

// 1. Lớp bao bọc (TaskResponse)
data class TaskListResponse(
    // Tên thuộc tính trong Kotlin, SerializedName là tên trong JSON
    val isSuccess: Boolean,
    val message: String,
    @SerializedName("data") // KHẮC PHỤC: JSON dùng "data", không phải "tasks"
    val tasks: List<Task>
)

// 2. Lớp Task chính (Đã thêm các trường còn thiếu)
data class Task(
    val id: Int,
    val title: String,
    val description: String?,
    val status: String?,
    val priority: String?,
    val category: String?,

    // Đã thêm các trường thời gian
    val dueDate: String?,
    val createdAt: String?,
    val updatedAt: String?,

    val subtasks: List<Subtask> = emptyList(),
    val attachments: List<Attachment> = emptyList(),
    val reminders: List<Reminder> = emptyList() // THÊM: Thiếu trong model cũ
)

// 3. Lớp Subtask
data class Subtask(
    val id: Int,
    val title: String,
    @SerializedName("isCompleted") // KHẮC PHỤC: JSON dùng "isCompleted"
    val completed: Boolean
)

// 4. Lớp Attachment
data class Attachment(
    val id: Int,
    @SerializedName("fileName") // KHẮC PHỤC: JSON dùng "fileName"
    val name: String,
    @SerializedName("fileUrl") // KHẮC PHỤC: JSON dùng "fileUrl"
    val url: String? = null
)

// 5. Lớp Reminder (Đã thêm)
data class Reminder(
    val id: Int,
    val time: String,
    val type: String
)