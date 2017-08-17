package loadinglibrary.manager

/**
 * Created by Hatim Liu on 2017/8/16.
 * loading全局统一配置
 */
class LoadingManager(var loadText: String = "正在加载",
                     var successText: String = "加载成功",
                     var failedText: String = "加载失败",
                     var textSize: Float = 18f,
                     var isOpenAnim: Boolean = true,
                     var dialogSize: Int = 160,
                     var interceptBack: Boolean = true) {


    fun isOpenAnim(boolean: Boolean): LoadingManager {
        isOpenAnim = boolean
        return this
    }

    fun textSize(size: Float): LoadingManager {
        textSize = size
        return this
    }

    fun failedText(string: String): LoadingManager {
        failedText = string
        return this
    }


    fun loadText(string: String): LoadingManager {
        loadText = string
        return this
    }

    fun successText(string: String): LoadingManager {
        successText = string
        return this
    }
}