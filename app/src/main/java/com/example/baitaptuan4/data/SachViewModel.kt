package com.example.baitaptuan4.data

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class SachViewModel : ViewModel() {
    // danh sách sách dùng SnapshotStateList để Compose tự cập nhật UI
    val sachList: SnapshotStateList<Sach> = mutableStateListOf()

    fun themSach(name: String) {
        if (name.isNotBlank()) {
            sachList.add(Sach(name)) // ✅ Thêm sách vào danh sách
        }
    }
}
