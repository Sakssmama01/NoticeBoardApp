package com.example.noticeboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ItemNotice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_notice) // ✅ Make sure this XML exists
    }
}
