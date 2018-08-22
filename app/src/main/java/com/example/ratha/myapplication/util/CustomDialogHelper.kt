package com.example.ratha.myapplication.util

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CustomDialogHelper : DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val items= arrayOf<CharSequence>("Report...","Copy Link","Turn On Post Notification",
                "Share on Messenger","Share on Whatsapp","Unfollow","Mute")
        val builder= AlertDialog.Builder(activity)
        builder.setItems(items, {dialog, which ->( dialog.dismiss() )})
        return builder.create()
    }
}