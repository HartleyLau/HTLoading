package loadinglibrary.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.view.animation.*


/**
 * Created by Hatim Liu on 2017/8/16.
 */
class LoadingView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var mWidth = 0f
    private var mPadding = 0f
    private var startAngle = 0f
    private val mPaint: Paint = Paint()
    private val color = Color.argb(100, 255, 255, 255)
    private val mPaint2: Paint = Paint()
    private var valueAnimator = ValueAnimator.ofFloat(0f, 1f)

    init {
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.STROKE
        mPaint.color = color
        mPaint.strokeWidth = 8f
        mPaint2.isAntiAlias = true
        mPaint2.style = Paint.Style.STROKE
        mPaint2.color = color
        mPaint2.strokeWidth = 8f
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint2.color = color
        canvas.drawCircle(mWidth / 2, mWidth / 2, mWidth / 2 - mPadding, mPaint2)
        mPaint.color = Color.WHITE
        val rectF = RectF(mPadding, mPadding, mWidth - mPadding, mWidth - mPadding)
        canvas.drawArc(rectF, startAngle, 100f, false, mPaint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (measuredWidth > height)
            mWidth = measuredHeight.toFloat()
        else
            mWidth = measuredWidth.toFloat()
        mPadding = 5f
    }

    fun startAnim(speed: Long = 1000) {
        stopAnim()
        startViewAnim(0f, 1f, speed)
    }

    fun stopAnim() {
        clearAnimation()
        valueAnimator.repeatCount = 1
        valueAnimator.cancel()
        valueAnimator.end()
    }

    private fun startViewAnim(startF: Float, endF: Float, time: Long) {
        valueAnimator.duration = time
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.repeatMode = ValueAnimator.RESTART

        valueAnimator.addUpdateListener({ valueAnimator ->
            val value = valueAnimator.animatedValue as Float
            startAngle = 360 * value

            invalidate()
        })
        valueAnimator.addListener(
                object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                    }
                }
        )
        valueAnimator.start()
    }

}