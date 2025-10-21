package com.example.baitaptuan4.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel

class SinhVienViewModel : ViewModel() {
    val sinhvienList: SnapshotStateList<String> = mutableStateListOf()

    fun themSinhVien(name: String) {
        if (name.isNotBlank() && !sinhvienList.contains(name)) {
            sinhvienList.add(name)
        }
    }
}
