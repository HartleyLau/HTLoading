package com.superlht.htloading.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import com.superlht.htloading.listener.DrawFinishListener

/**
 * Created by Hatim Liu on 2017/8/16.
 */
class SuccessView(context: Context?, attrs: AttributeSet?) : BaseLoadingView(context, attrs) {
    private val mPaint: Paint = Paint()
    private var valueAnimator = ValueAnimator.ofFloat(0f, 2f)
    private var endAngle = 0f
    private val mGap = 15f //内部×与圆的距离
    private var progress = 0f
    private var listener: DrawFinishListener? = null


    init {
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.STROKE
        mPaint.color = color
        mPaint.strokeWidth = 8f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val rectF = RectF(mPadding, mPadding, mWidth - mPadding, mWidth - mPadding)
        canvas.drawArc(rectF, 0f, endAngle, false, mPaint)
        if (progress in 1f..1.5f) {
            canvas.drawLine(
                    mWidth / 4.7f,
                    mWidth / 1.7f,
                    (progress - 1f) * 2 * mWidth / 4 + mWidth / 4.7f,
                    (progress - 1f) * 2 * mWidth / 4 + mWidth / 2
                    , mPaint)
        }
        if (progress in 1.5f..2f) {
            canvas.drawLine(
                    mWidth / 4.7f,
                    mWidth / 1.7f,
                    mWidth / 4 + mWidth / 4.7f,
                    mWidth / 4 + mWidth / 2,
                    mPaint)
            canvas.drawLine(
                    mWidth / 4 + mWidth / 5,
                    mWidth / 4 + mWidth / 2,
                    mWidth / 4 + mWidth / 5 + (progress - 1.5f) * 2 * mWidth / 3,
                    mWidth / 4 + mWidth / 2 - (progress - 1.5f) * 2 * mWidth / 3,
                    mPaint)
        }

    }

    fun setOnDrawFinishListener(listener: DrawFinishListener) {
        this.listener = listener
    }

    fun startAnim(speed: Long = 1000) {
        stopAnim()
        startViewAnim(speed)
    }

    fun stopAnim() {
        clearAnimation()
        valueAnimator.repeatCount = 1
        valueAnimator.cancel()
        valueAnimator.end()
    }

    private fun startViewAnim(time: Long) {
        valueAnimator.duration = time
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.repeatCount = 0

        valueAnimator.addUpdateListener({ valueAnimator ->
            val value = valueAnimator.animatedValue as Float
            endAngle = 360 * value
            progress = value
            invalidate()
        })
        valueAnimator.addListener(
                object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        listener?.onDrawFinished(this@SuccessView)
                    }
                }
        )
        valueAnimator.start()
    }

}