package com.superlht.htloading.view

import android.app.Dialog
import android.content.Context
import android.os.Handler
import android.support.annotation.StyleRes
import android.view.ContextThemeWrapper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.superlht.htloading.R
import kotlinx.android.synthetic.main.loading_view.view.*
import com.superlht.htloading.listener.DrawFinishListener
import com.superlht.htloading.listener.OnDialogDismissListener
import com.superlht.htloading.manager.HTLoadingManager
import com.superlht.htloading.spinkit.SpinKitView
import java.util.*


/**
 * Created by Hatim Liu on 2017/8/16.
 */
class HTLoading(private val context: Context) : DrawFinishListener {

    private val manager = HTLoadingManager.getManager()

    private val view: View = LayoutInflater.from(context).inflate(R.layout.loading_view, null)

    private val viewList = ArrayList<View>()

    private val loadingDialog = Dialog(context, R.style.loading_dialog)

    private var textSize: Float = manager.textSize

    private var loadingStr: String = manager.loadText

    private var successStr: String = manager.successText

    private var failedStr: String = manager.failedText

    private var interceptBack = true

    private var listener: OnDialogDismissListener? = null

    private var customSuccessView: View? = null

    private var customFailedView: View? = null

    private var customLoadingView: View? = null

    private var dismissDelay: Long = manager.dismissDelay

    private var drawColor: Int = manager.drawColor

    private var isAutoDismiss: Boolean = manager.isAutoDismiss


    init {
        viewList.add(view.loadingView)
        viewList.add(view.failedView)
        viewList.add(view.successView)
        viewList.add(view.customView)
//        viewList.add(com.superlht.htloading.view.spinKitView)
        view.failedView.setOnDrawFinishListener(this)
        view.successView.setOnDrawFinishListener(this)
        loadingDialog.setCancelable(!interceptBack)
        loadingDialog.setContentView(view.loading_dialog, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT))
        initStyle()
    }

    private fun initStyle() {
//        setSize(com.superlht.htloading.manager.dialogSize)
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
            onDrawFinished(it)
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
            onDrawFinished(it)
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
    fun setOnDialogDismissListener(listener: OnDialogDismissListener) {
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

    fun setFailedText(string: String): HTLoading {
        failedStr = string
        return this
    }

    fun setIsAutoDismiss(boolean: Boolean): HTLoading {
        isAutoDismiss = boolean
        return this
    }

    fun showSpinKit(@StyleRes style: Int) {
        hideAll()
        val spinView = SpinKitView(ContextThemeWrapper(context, style))
        spinView?.let {
            view.customView.removeAllViews()
            view.customView.visibility = View.VISIBLE
            view.customView.addView(it)
        }
        view.text.visibility = View.GONE
        loadingDialog.show()
    }

    fun showSuccess() {
        hideAll()
        view.successView.visibility = View.VISIBLE
        loadingDialog.show()
        view.text.text = successStr
        view.successView.startAnim()
    }

    fun showFailed() {
        hideAll()
        view.failedView.visibility = View.VISIBLE
        loadingDialog.show()
        view.text.text = failedStr
        view.failedView.startAnim()
    }

    fun setInterceptBack(boolean: Boolean): HTLoading {
        interceptBack = boolean
        loadingDialog.setCancelable(!interceptBack)
        return this
    }

    fun setTextSize(size: Float): HTLoading {
        textSize = size
        view.text.textSize = textSize
        return this
    }

    fun setCustomViewSize(size: Int): HTLoading {
        view.customView.layoutParams = LinearLayout.LayoutParams(size, size)
        return this
    }

    fun setDialogBackground(color: Int): HTLoading {
        view.loading_dialog.setBackgroundColor(color)
        return this
    }

    fun setSize(size: Int): HTLoading {
        setSize(size, size)
        return this
    }

    fun setDrawColor(color: Int): HTLoading {
        drawColor = color
        viewList
                .filterIsInstance<BaseLoadingView>()
                .forEach { it.setDrawColor(color) }
        return this
    }

    fun setSize(width: Int, height: Int): HTLoading {
        loadingDialog.window.setGravity(Gravity.CENTER)
        val lp = loadingDialog.window.attributes
        lp.width = width
        lp.height = height
        loadingDialog.window.attributes = lp
        loadingDialog.setContentView(view.loading_dialog, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT))
//        com.superlht.htloading.view.loadingView.layoutParams.height = height
//        com.superlht.htloading.view.loadingView.layoutParams.width = width
        return this
    }


    private fun hideAll() {
        view.text.visibility = View.VISIBLE
        for (view in viewList) {
            view.visibility = View.GONE
        }
    }

    fun dismiss() {
        hideAll()
        loadingDialog.hide()
        listener?.dialogDismiss()
    }

    //动画加载完成时的回调
    override fun onDrawFinished(view: View) {
        if (isAutoDismiss)
            Handler().postDelayed({
                dismiss()
            }, dismissDelay)
    }

}