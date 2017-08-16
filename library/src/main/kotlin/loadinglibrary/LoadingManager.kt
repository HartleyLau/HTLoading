package loadinglibrary

import android.content.res.Resources
import superlht.com.loadinglibrary.R

/**
 * Created by Hatim Liu on 2017/8/16.
 */
class LoadingManager(loadText: String = Resources.getSystem().getString(R.string.LoadText)) {


    //    var loadText: String =
    var successText: String = Resources.getSystem().getString(R.string.SuccessText)
    var failedText: String = Resources.getSystem().getString(R.string.FailedText)
    var textSize: Float? = null
    var isOpenAnim: Boolean? = null
    var contentSize: Int? = null

    fun successText(string: String): LoadingManager {
        return this
    }
}