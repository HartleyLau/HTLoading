package loadinglibrary.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import loadinglibrary.listener.DrawFinishListener

/**
 * Created by Hatim Liu on 2017/8/16.
 */
class FailedView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var listener: DrawFinishListener? = null

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        listener?.onDrawFinished(this)
    }

    fun setOnDrawFinishListener(listener: DrawFinishListener) {
        this.listener = listener
    }
}