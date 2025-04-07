package com.example.noticeboard

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoticeAdapter(private val noticeList: List<Notice>) :
    RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

    inner class NoticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvNoticeTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_notice, parent, false)
        return NoticeViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        val notice = noticeList[position]
        holder.tvTitle.text = notice.title

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, NoticeDetailActivity::class.java)
            intent.putExtra("notice_title", notice.title)
            intent.putExtra("notice_description", notice.description)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = noticeList.size
}
