package com.example.noticeboard

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notice::class], version = 1, exportSchema = false)
abstract class NoticeDatabase : RoomDatabase() {
    abstract fun noticeDao(): NoticeDao

    companion object {
        @Volatile
        private var INSTANCE: NoticeDatabase? = null

        fun getDatabase(context: Context): NoticeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoticeDatabase::class.java,
                    "notice_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
