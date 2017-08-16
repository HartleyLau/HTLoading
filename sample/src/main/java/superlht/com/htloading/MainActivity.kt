package superlht.com.htloading

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import loadinglibrary.LoadingManager
import loadinglibrary.view.HTLoading

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        HTLoading.init(LoadingManager())
    }
}
