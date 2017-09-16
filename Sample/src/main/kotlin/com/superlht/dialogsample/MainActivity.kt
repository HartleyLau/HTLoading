package com.superlht.dialogsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView.setOnItemClickListener { _, _, p, _ ->
            when (p) {
                0 -> startActivity<DefaultActivity>()
                1 -> startActivity<CustomActivity>()
            }
        }
    }
}
