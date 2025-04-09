package com.example.noticeboard

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noticeboard.R

class NoticeAdapter : ListAdapter<Notice, NoticeAdapter.NoticeViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_notice, parent, false)
        return NoticeViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        val notice = getItem(position)
        holder.bind(notice)
    }

    inner class NoticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.tvTitle)

        fun bind(notice: Notice) {
            title.text = notice.title
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, NoticeDetailActivity::class.java)
                intent.putExtra("notice_title", notice.title)
                intent.putExtra("notice_description", notice.description)
                itemView.context.startActivity(intent)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Notice>() {
        override fun areItemsTheSame(oldItem: Notice, newItem: Notice) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Notice, newItem: Notice) = oldItem == newItem
    }
}
