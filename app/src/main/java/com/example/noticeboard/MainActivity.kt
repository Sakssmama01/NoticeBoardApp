package com.example.noticeboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var noticeAdapter: NoticeAdapter
    private val noticeList = mutableListOf("Notice 1", "Notice 2", "Notice 3")
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        noticeAdapter = NoticeAdapter(noticeList)
        recyclerView.adapter = noticeAdapter

        fab = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, DialogAddNotice::class.java)
            startActivityForResult(intent, 1)  // Start activity for result
        }
    }

    // Handle the result from DialogAddNotice
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val newNotice = data?.getStringExtra("new_notice")
            if (!newNotice.isNullOrEmpty()) {
                noticeList.add(newNotice) // Add new notice to the list
                noticeAdapter.notifyDataSetChanged() // Refresh RecyclerView
            }
        }
    }
}
