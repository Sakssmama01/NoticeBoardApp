package com.example.noticeboard

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        // Only Common Noticeboard clickable
        findViewById<LinearLayout>(R.id.layoutCommonNoticeboard).setOnClickListener {
            startActivity(Intent(this, CommonNoticeboardActivity::class.java))
        }

        // No click listeners for other layouts yet
    }
}
