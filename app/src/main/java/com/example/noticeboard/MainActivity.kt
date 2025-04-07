package com.example.noticeboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), AddNoticeDialog.NoticeDialogListener {

    private lateinit var noticeAdapter: NoticeAdapter
    private val noticeList = mutableListOf<Notice>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        noticeAdapter = NoticeAdapter(noticeList)
        recyclerView.adapter = noticeAdapter

        val fab = findViewById<FloatingActionButton>(R.id.fabAddNotice)
        fab.setOnClickListener {
            AddNoticeDialog().show(supportFragmentManager, "AddNoticeDialog")
        }
    }

    override fun onNoticeAdded(title: String, description: String) {
        val notice = Notice(title, description)
        noticeList.add(notice)
        noticeAdapter.notifyItemInserted(noticeList.size - 1)
    }
}
