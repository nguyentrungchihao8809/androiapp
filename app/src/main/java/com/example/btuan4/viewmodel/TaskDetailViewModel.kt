package com.example.btuan4.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.btuan4.models.Task
import com.example.btuan4.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class DetailState {
    object Loading : DetailState()
    data class Success(val task: Task) : DetailState()
    data class Error(val msg: String) : DetailState()
    object Deleted : DetailState()
}

class TaskDetailViewModel(private val repo: TaskRepository) : ViewModel() {

    private val _state = MutableStateFlow<DetailState>(DetailState.Loading)
    val state: StateFlow<DetailState> = _state

    /** 🔹 Tải chi tiết 1 Task. Cần truyền ID của task cần tải. */
    fun loadTask(taskId: Int) { // ĐÃ SỬA: Thêm taskId
        viewModelScope.launch {
            _state.value = DetailState.Loading
            try {
                val resp = repo.getTask(taskId) // ĐÃ SỬA: Truyền taskId
                if (resp.isSuccessful) {
                    val task = resp.body()
                    if (task != null) {
                        _state.value = DetailState.Success(task)
                    } else {
                        _state.value = DetailState.Error("Không có dữ liệu task (body trống)")
                    }
                } else {
                    _state.value = DetailState.Error("Lỗi HTTP ${resp.code()}: ${resp.message()}")
                }
            } catch (e: Exception) {
                _state.value = DetailState.Error(e.localizedMessage ?: "Lỗi không xác định")
            }
        }
    }

    /** 🔹 Xoá Task. Cần truyền ID của task cần xóa. */
    fun deleteTask(taskId: Int) { // ĐÃ SỬA: Thêm taskId
        viewModelScope.launch {
            try {
                val resp = repo.deleteTask(taskId) // ĐÃ SỬA: Truyền taskId
                if (resp.isSuccessful) {
                    _state.value = DetailState.Deleted
                } else {
                    _state.value = DetailState.Error("Xoá thất bại: HTTP ${resp.code()}")
                }
            } catch (e: Exception) {
                _state.value = DetailState.Error(e.localizedMessage ?: "Lỗi không xác định")
            }
        }
    }

    fun resetState() {
        _state.value = DetailState.Loading
    }
}