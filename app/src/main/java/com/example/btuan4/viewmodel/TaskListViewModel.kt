package com.example.btuan4.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.btuan4.models.Task
import com.example.btuan4.models.TaskListResponse
import com.example.btuan4.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class UiState {
    object Loading : UiState()
    data class Success(val tasks: List<Task>) : UiState()
    data class Error(val message: String) : UiState()
    object Empty : UiState()
}

class TaskListViewModel(private val repo: TaskRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    fun fetchTasks() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val resp = repo.getTasks()
                if (resp.isSuccessful) {
                    val body = resp.body()
                    val tasks = body?.tasks ?: emptyList()   // ✅ Lấy danh sách từ TaskListResponse
                    if (tasks.isEmpty()) {
                        _uiState.value = UiState.Empty
                    } else {
                        _uiState.value = UiState.Success(tasks)
                    }
                } else {
                    _uiState.value = UiState.Error("HTTP ${resp.code()}: ${resp.message()}")
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.localizedMessage ?: "Unknown error")
            }
        }
    }
}
