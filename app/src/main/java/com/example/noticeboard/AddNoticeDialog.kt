package com.example.noticeboard

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.noticeboard.R


class AddNoticeDialog(private val onAdd: (String, String) -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = layoutInflater.inflate(R.layout.activity_dilogue_add_notice, null)
        val titleInput = view.findViewById<EditText>(R.id.etTitle)
        val descriptionInput = view.findViewById<EditText>(R.id.etDescription)

        return AlertDialog.Builder(requireContext())
            .setTitle("Add Notice")
            .setView(view)
            .setPositiveButton("Add") { _, _ ->
                onAdd(titleInput.text.toString(), descriptionInput.text.toString())
            }
            .setNegativeButton("Cancel", null)
            .create()
    }
}
