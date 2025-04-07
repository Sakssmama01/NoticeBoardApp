package com.example.noticeboard

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class AddNoticeDialog : DialogFragment() {

    interface NoticeDialogListener {
        fun onNoticeAdded(title: String, description: String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = requireActivity().layoutInflater.inflate(R.layout.activity_dilogue_add_notice, null)
        val etTitle = view.findViewById<EditText>(R.id.etTitle)
        val etDescription = view.findViewById<EditText>(R.id.etDescription)

        return AlertDialog.Builder(requireContext())
            .setTitle("Add New Notice")
            .setView(view)
            .setPositiveButton("Add") { _, _ ->
                val title = etTitle.text.toString()
                val description = etDescription.text.toString()
                (activity as? NoticeDialogListener)?.onNoticeAdded(title, description)
            }
            .setNegativeButton("Cancel", null)
            .create()
    }
}
