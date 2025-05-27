package com.example.noticeboard

import NoticeRepository
import android.app.Application

class NoticeApp : Application() {
    val database by lazy {
        NoticeDatabase.getDatabase(this)
    }

    val repository by lazy {
        NoticeRepository(database.noticeDao())
    }
}
