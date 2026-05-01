package com.omkar.docviewer.viewers
import android.widget.FrameLayout
import android.net.Uri
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.apache.poi.xwpf.usermodel.XWPFDocument

class DocxViewer(
    private val activity: AppCompatActivity,
    private val uri: Uri,
    private val container: FrameLayout
)
{

    fun render() {
        val input = activity.contentResolver.openInputStream(uri)
        val doc = XWPFDocument(input)

        val textView = TextView(activity)
        textView.textSize = 16f

        val sb = StringBuilder()
        for (para in doc.paragraphs) {
            sb.append(para.text).append("\n\n")
        }

        textView.text = sb.toString()

        val scroll = ScrollView(activity)
        scroll.addView(textView)

        container.addView(scroll)

    }
}
