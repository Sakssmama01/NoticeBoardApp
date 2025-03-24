package com.example.noticeboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noticeboard.R  // Ensure R is imported

class NoticeAdapter(private val notices: List<String>) :
    RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

    class NoticeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNotice: TextView = view.findViewById(R.id.tvNotice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        // Correcting the layout reference
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_notice, parent, false)
        return NoticeViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.tvNotice.text = notices[position]
    }

    override fun getItemCount(): Int = notices.size
}
