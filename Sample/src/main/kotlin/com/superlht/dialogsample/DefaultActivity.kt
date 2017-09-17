package com.superlht.dialogsample
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.superlht.htloading.view.HTLoading
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by lht on 2017-09-13.
 */
class DefaultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loading = HTLoading(this)
        loading.show()
        doAsync {
            Thread.sleep(1000)
            uiThread { loading.showFailed() }
        }
    }
}