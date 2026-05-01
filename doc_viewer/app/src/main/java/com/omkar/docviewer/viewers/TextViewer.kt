package com.omkar.docviewer.viewers

import android.net.Uri
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.FrameLayout

class TextViewer(
    private val activity: AppCompatActivity,
    private val uri: Uri,
    private val container: FrameLayout
)
{
    fun render() {
        val input = activity.contentResolver.openInputStream(uri)
        val text = input?.bufferedReader()?.use { it.readText() }

        val tv = TextView(activity)
        tv.text = text
        tv.textSize = 16f

        val scroll = ScrollView(activity)
        scroll.addView(tv)

        container.addView(scroll)

    }
}
