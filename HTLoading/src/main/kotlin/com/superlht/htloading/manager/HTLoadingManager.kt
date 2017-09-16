package com.superlht.htloading.manager

import android.graphics.Color

/**
 * Created by Hatim Liu on 2017/8/16.
 * loading全局统一配置
 */

class HTLoadingManager {
    companion object {
        internal var loadText: String = "正在加载"
        internal var successText: String = "加载成功"
        internal var failedText: String = "加载失败"
        internal var drawColor: Int = Color.WHITE
        internal var textSize: Float = 18f
        internal var isOpenAnim: Boolean = true
        internal var dialogSize: Int = 400
        internal var interceptBack: Boolean = true
        internal var dismissDelay: Long = 2000
        internal var isAutoDismiss: Boolean = true
        internal fun getManager(): HTLoadingManager.Companion {
            return this@Companion
        }

        fun isOpenAnim(boolean: Boolean): HTLoadingManager.Companion {
            isOpenAnim = boolean
            return this@Companion
        }

        fun textSize(size: Float): HTLoadingManager.Companion {
            textSize = size
            return this@Companion
        }

        fun failedText(string: String): HTLoadingManager.Companion {
            failedText = string
            return this@Companion
        }


        fun loadText(string: String): HTLoadingManager.Companion {
            loadText = string
            return this@Companion
        }

        fun successText(string: String): HTLoadingManager.Companion {
            successText = string
            return this@Companion
        }

        fun delay(time: Long): HTLoadingManager.Companion {
            dismissDelay = time
            return this@Companion
        }

        fun drawColor(color: Int): HTLoadingManager.Companion {
            drawColor = color
            return this@Companion
        }

        fun isAutoDismiss(boolean: Boolean): HTLoadingManager.Companion {
            isAutoDismiss = boolean
            return this@Companion
        }
    }


}