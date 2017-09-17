package com.superlht.dialogsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.superlht.htloading.view.HTLoading

/**
 * Created by Hatim Liu on 2017/9/17.
 */
class SpinKitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_default)
        val loading = HTLoading(this)
        loading.setInterceptBack(false)
        loading.showSpinKit(R.style.SpinKitView_CubeGrid)
    }
}