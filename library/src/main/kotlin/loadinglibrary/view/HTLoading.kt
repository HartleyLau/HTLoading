package loadinglibrary.view

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.loading_view.view.*
import loadinglibrary.listener.DialogDismissListener
import loadinglibrary.manager.LoadingManager
import loadinglibrary.listener.DrawFinishListener
import superlht.com.loadinglibrary.R
import java.util.*

/**
 * Created by Hatim Liu on 2017/8/16.
 */
class HTLoading(context: Context) : DrawFinishListener {

    private val view: View = LayoutInflater.from(context).inflate(R.layout.loading_view, null)

    private val viewList = ArrayList<View>()

    private val loadingDialog = Dialog(context, R.style.loading_dialog)

    private var textSize: Float = manager.textSize

    private var loadingStr: String = manager.loadText

    private var successStr: String = manager.successText

    private var failedStr: String = manager.failedText

    private var interceptBack = true

    private var listener: DialogDismissListener? = null

    private var customSuccessView: View? = null

    private var customFailedView: View? = null

    private var customLoadingView: View? = null


    init {
//        viewList.add(view.failedView)
        viewList.add(view.loadingView)
        viewList.add(view.failedView)
        view.failedView.setOnDrawFinishListener(this)
        loadingDialog.setCancelable(!interceptBack)
        loadingDialog.setContentView(view.loading_dialog, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT))
        initStyle()
    }

    private fun initStyle() {
        setSize(manager.dialogSize)
        setTextSize(manager.textSize)
    }

    fun show() {
        hideAll()
        view.loadingView.visibility = View.VISIBLE
        loadingDialog.show()
        view.text.text = loadingStr
        view.loadingView.startAnim(1000)
    }

    //显示自定义加载界面
    fun showCustomLoading() {
        hideAll()
        customLoadingView?.let {
            view.customView.removeAllViews()
            view.customView.visibility = View.VISIBLE
            view.customView.addView(it)
            loadingDialog.show()
        }
    }

    //显示自定义成功界面
    fun showCustomSuccess() {
        hideAll()
        customSuccessView?.let {
            view.customView.removeAllViews()
            view.customView.visibility = View.VISIBLE
            view.customView.addView(it)
            loadingDialog.show()
        }
    }

    //显示自定义失败界面
    fun showCustomFailed() {
        hideAll()
        customFailedView?.let {
            view.customView.removeAllViews()
            view.customView.visibility = View.VISIBLE
            view.customView.addView(it)
            loadingDialog.show()
        }
    }

    //设置自定义成功界面
    fun setSuccessView(view: View): HTLoading {
        customSuccessView = view
        return this
    }

    //设置自定义失败界面
    fun setFailedView(view: View): HTLoading {
        customFailedView = view
        return this
    }

    //设置自定义加载界面
    fun setLoadingView(view: View): HTLoading {
        customLoadingView = view
        return this
    }

    //当Dialog消失时的回调
    fun setOnDialogDismissListener(listener: DialogDismissListener) {
        this.listener = listener
    }

    fun setLoadingText(string: String): HTLoading {
        loadingStr = string
        return this
    }

    fun setSuccessText(string: String): HTLoading {
        successStr = string
        return this
    }

    fun setFailedText(string: String) {
        failedStr = string
    }


    fun showSuccess() {

    }

    fun showFailed() {
        hideAll()
        view.failedView.visibility = View.VISIBLE
        loadingDialog.show()
        view.text.text = failedStr
        view.failedView.startAnim()
    }

    fun setnterceptBack(boolean: Boolean) {
        interceptBack = boolean
        loadingDialog.setCancelable(!interceptBack)
    }

    fun setTextSize(size: Float) {
        textSize = size
        view.text.textSize = textSize
    }

    fun setSize(size: Int) {
        setSize(size, size)
    }

    fun setDrawColor(color: Int) {

    }

    fun setSize(width: Int, height: Int) {
        view.loadingView.layoutParams.height = height
        view.loadingView.layoutParams.width = width
    }


    private fun hideAll() {
        for (view in viewList) {
            view.visibility = View.GONE
        }
    }

    fun dismiss() {
        hideAll()
        loadingDialog.hide()
        listener?.dialogDismiss()
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