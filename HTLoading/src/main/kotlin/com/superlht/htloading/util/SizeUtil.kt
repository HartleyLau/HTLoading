package com.superlht.htloading.util

import android.content.Context

/**
 * Created by Hatim Liu on 2017/8/17.
 * 屏幕尺寸计算的相关类
 */
class SizeUtil {
    companion object {

        /**
         * dp转px
         */
        fun dip2px(context: Context, dpValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (dpValue * scale + 0.5f).toInt()
        }

        /**
         * px转dp
         */
        fun px2dip(context: Context, pxValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (pxValue / scale + 0.5f).toInt()
        }

        /**
         * px转sp
         */
        fun px2sp(context: Context, spValue: Float): Int {
            val fontScale = context.resources.displayMetrics.scaledDensity
            return (spValue / fontScale + 0.5f).toInt()
        }

        /**
         * sp转px
         */
        fun sp2px(context: Context, spValue: Float): Int {
            val fontScale = context.resources.displayMetrics.scaledDensity
            return (spValue * fontScale + 0.5f).toInt()
        }
    }
}