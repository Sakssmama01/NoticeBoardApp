package com.example.noticeboard

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class NoticeViewModel(private val repository: NoticeRepository) : ViewModel() {

    val allNotices: LiveData<List<Notice>> = repository.allNotices.asLiveData()

    fun insert(notice: Notice) = viewModelScope.launch {
        repository.insert(notice)
    }
}
