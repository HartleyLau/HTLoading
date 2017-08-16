package loadinglibrary.view

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.loading_view.view.*
import loadinglibrary.LoadingManager
import loadinglibrary.listener.DrawFinishListener
import superlht.com.loadinglibrary.R
import java.util.*

/**
 * Created by Hatim Liu on 2017/8/16.
 */
class HTLoading(context: Context) : DrawFinishListener {


    private val view: View = LayoutInflater.from(context).inflate(R.layout.loading_view, null)
    private val viewList = ArrayList<View>()

    private var interceptBack = true

    private val loadingDialog = Dialog(context, R.style.loading_dialog)

    private var successStr: String = manager.successText

    init {
        viewList.add(view.failedView)
        viewList.add(view.loadingView)
        viewList.add(view.successView)
        view.failedView.setOnDrawFinishListener(this)
        loadingDialog.setCancelable(!interceptBack)
        loadingDialog.setContentView(view.loading_dialog, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT))
        initStyle()
    }

    private fun initStyle() {
        if (manager != null) {
            manager?.contentSize?.let { setSize(it) }
            manager?.failedText?.let { }
        }
    }

    fun Dialog.onBackPressed() {
        if (interceptBack) {
            return
        }
        dismiss()
    }

    fun show() {

    }

    fun dismiss() {
        viewList.clear()

    }

    fun showSuccess() {

    }

    fun showFailed() {

    }

    fun setnterceptBack(boolean: Boolean) {

    }

    fun setSize(size: Int) {

    }

    private fun setSuccessText(string: String) {


    }

    private fun hideAll() {
        for (view in viewList) {
            view.visibility = View.GONE
        }
    }

    override fun onDrawFinished(view: View) {
    }

    companion object {
        private var manager: LoadingManager = LoadingManager()
        fun init(manager: LoadingManager) {
            this.manager = manager
        }
    }
}