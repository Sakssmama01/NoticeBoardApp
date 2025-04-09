package com.example.noticeboard

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var noticeAdapter: NoticeAdapter
    private val viewModel: NoticeViewModel by viewModels {
        NoticeViewModelFactory((application as NoticeApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        noticeAdapter = NoticeAdapter()
        recyclerView.adapter = noticeAdapter

        viewModel.allNotices.observe(this, Observer { notices ->
            notices?.let { noticeAdapter.submitList(it) }
        })

        findViewById<FloatingActionButton>(R.id.fabAdd).setOnClickListener {
            AddNoticeDialog { title, description ->
                viewModel.insert(Notice(title = title, description = description))
            }.show(supportFragmentManager, "AddNoticeDialog")
        }
    }
}
