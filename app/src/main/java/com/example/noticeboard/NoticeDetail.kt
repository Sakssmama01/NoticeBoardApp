package com.example.noticeboard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.noticeboard.R

class NoticeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_detail)

        val title = intent.getStringExtra("notice_title")
        val description = intent.getStringExtra("notice_description")

        findViewById<TextView>(R.id.tvNoticeTitle).text = title
        findViewById<TextView>(R.id.tvNoticeDescription).text = description
    }
}
