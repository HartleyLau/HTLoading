package com.superlht.dialogsample
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.superlht.dialogsample.R
import com.superlht.htloading.util.SizeUtil
import com.superlht.htloading.view.HTLoading

/**
 * Created by lht on 2017-09-13.
 */
class CustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_default)
        val view = layoutInflater.inflate(R.layout.layout_anim, null)
        val loading = HTLoading(this)
                .setLoadingView(view)
                .setSize(SizeUtil.dip2px(this, 300f))
                .setCustomViewSize(SizeUtil.dip2px(this, 250f))
                .setDialogBackground(Color.TRANSPARENT)
                .setInterceptBack(false)
        loading.showCustomLoading()
    }
}