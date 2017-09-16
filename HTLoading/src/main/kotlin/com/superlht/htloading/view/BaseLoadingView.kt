package com.superlht.htloading.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.superlht.htloading.manager.HTLoadingManager

/**
 * Created by lht on 2017-09-13.
 */
open class BaseLoadingView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    protected var mWidth = 0f
    protected var mPadding = 0f
    protected var color = HTLoadingManager.drawColor

    fun setDrawColor(color: Int) {
        this.color = color
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = if (measuredWidth > height)
            measuredHeight.toFloat()
        else
            measuredWidth.toFloat()
        mPadding = 5f
    }
}