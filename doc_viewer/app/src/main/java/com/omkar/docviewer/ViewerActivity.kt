package com.omkar.docviewer

import android.net.Uri
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.appbar.MaterialToolbar
import com.omkar.docviewer.viewers.*

class ViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewer)

        // Toolbar setup
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.inflateMenu(R.menu.viewer_menu)

        toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.toggleTheme) {
                val night = AppCompatDelegate.getDefaultNightMode()
                AppCompatDelegate.setDefaultNightMode(
                    if (night == AppCompatDelegate.MODE_NIGHT_YES)
                        AppCompatDelegate.MODE_NIGHT_NO
                    else
                        AppCompatDelegate.MODE_NIGHT_YES
                )
                true
            } else false
        }

        // Get file
        val uri = Uri.parse(intent.getStringExtra("uri")!!)
        val fileName = uri.lastPathSegment ?: "Document"
        toolbar.title = fileName

        val container = findViewById<FrameLayout>(R.id.contentContainer)
        val pageText = findViewById<TextView>(R.id.pageIndicator)

        // Route to viewer
        when {
            fileName.endsWith(".pdf", true) -> {
                pageText.visibility = TextView.VISIBLE
                PdfViewer(
                    activity = this,
                    uri = uri,
                    container = container
                ) { page, total ->
                    pageText.text = "Page $page / $total"
                }.render()
            }

            fileName.endsWith(".docx", true) -> {
                pageText.visibility = TextView.GONE
                DocxViewer(this, uri, container).render()
            }

            fileName.endsWith(".pptx", true) -> {
                pageText.visibility = TextView.GONE
                PptViewer(this, uri, container).render()
            }

            fileName.endsWith(".txt", true) -> {
                pageText.visibility = TextView.GONE
                TextViewer(this, uri, container).render()
            }

            else -> finish()
        }
    }
}
