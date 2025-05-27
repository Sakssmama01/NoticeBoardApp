package com.example.noticeboard

import NoticeRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NoticeViewModelFactory(private val repository: NoticeRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoticeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoticeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
