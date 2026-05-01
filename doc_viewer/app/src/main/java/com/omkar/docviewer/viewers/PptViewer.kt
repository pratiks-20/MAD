package com.omkar.docviewer.viewers

import android.net.Uri
import android.widget.FrameLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.apache.poi.xslf.usermodel.XMLSlideShow
import org.apache.poi.xslf.usermodel.XSLFTextShape

class PptViewer(
    private val activity: AppCompatActivity,
    private val uri: Uri,
    private val container: FrameLayout
) {

    fun render() {
        val input = activity.contentResolver.openInputStream(uri)
        val ppt = XMLSlideShow(input)

        val tv = TextView(activity)
        tv.textSize = 16f

        val sb = StringBuilder()
        for (slide in ppt.slides) {
            for (shape in slide.shapes) {
                if (shape is XSLFTextShape) {
                    sb.append(shape.text).append("\n")
                }
            }
            sb.append("\n---\n")
        }

        tv.text = sb.toString()

        val scroll = ScrollView(activity)
        scroll.addView(tv)

        container.addView(scroll)
    }
}
