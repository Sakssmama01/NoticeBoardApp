package com.example.noticeboard

import android.app.Application

class NoticeApp : Application() {
    val database by lazy {
        NoticeDatabase.getDatabase(this)
    }

    val repository by lazy {
        NoticeRepository(database.noticeDao())
    }
}
