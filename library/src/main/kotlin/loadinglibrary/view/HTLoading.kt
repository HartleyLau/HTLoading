package loadinglibrary.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.loading_view.view.*
import loadinglibrary.listener.DrawFinishListener
import superlht.com.loadinglibrary.R
import java.util.*

/**
 * Created by Hatim Liu on 2017/8/16.
 */
class HTLoading(val context: Context) : DrawFinishListener {


    val view: View = LayoutInflater.from(context).inflate(R.layout.loading_view, null)
    val viewList = ArrayList<View>()

    init {
        viewList.add(view.failedView)
        viewList.add(view.loadingView)
        viewList.add(view.successView)
        view.failedView.setOnDrawFinishListener(this)
    }

    fun show() {
    }

    fun dismiss() {

    }

    fun showSuccess() {

    }

    fun showFailed() {

    }

    fun setnterceptBack(boolean: Boolean) {

    }

    fun setSize(size: Int) {

    }

    override fun onDrawFinished(view: View) {
    }
}