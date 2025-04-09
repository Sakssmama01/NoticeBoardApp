package com.example.noticeboard

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class NoticeRepository(private val noticeDao: NoticeDao) {

    val allNotices: Flow<List<Notice>> = noticeDao.getAllNotices()

    @WorkerThread
    suspend fun insert(notice: Notice) {
        noticeDao.insert(notice)
    }
}
