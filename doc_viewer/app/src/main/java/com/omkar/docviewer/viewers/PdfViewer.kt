package com.omkar.docviewer.viewers

import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.net.Uri
import android.os.ParcelFileDescriptor
import android.view.ScaleGestureDetector
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity

class PdfViewer(
    private val activity: AppCompatActivity,
    private val uri: Uri,
    private val container: FrameLayout,
    private val pageIndicator: (Int, Int) -> Unit
) {

    private var scaleFactor = 1f

    fun render() {
        val scroll = ScrollView(activity)
        val layout = LinearLayout(activity)
        layout.orientation = LinearLayout.VERTICAL
        scroll.addView(layout)

        val fd: ParcelFileDescriptor =
            activity.contentResolver.openFileDescriptor(uri, "r")!!
        val renderer = PdfRenderer(fd)

        val scaleDetector = ScaleGestureDetector(
            activity,
            object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
                override fun onScale(detector: ScaleGestureDetector): Boolean {
                    scaleFactor *= detector.scaleFactor
                    scaleFactor = scaleFactor.coerceIn(1f, 3f)
                    layout.scaleX = scaleFactor
                    layout.scaleY = scaleFactor
                    return true
                }
            }
        )

        scroll.setOnTouchListener { _, event ->
            scaleDetector.onTouchEvent(event)
            false
        }

        for (i in 0 until renderer.pageCount) {
            val page = renderer.openPage(i)
            val bitmap =
                Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
            page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)

            val image = ImageView(activity)
            image.setImageBitmap(bitmap)
            layout.addView(image)

            page.close()
        }

        scroll.viewTreeObserver.addOnScrollChangedListener {
            val pageNumber = (scroll.scrollY / scroll.height) + 1
            pageIndicator(pageNumber.coerceAtLeast(1), renderer.pageCount)
        }

        container.addView(scroll)
    }
}
