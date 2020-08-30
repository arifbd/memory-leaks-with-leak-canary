package com.ennoblesoft.leakcanaryexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LeakActivity : AppCompatActivity() {
    private val listener = Listener()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leak)
    }

    override fun onStart() {
        super.onStart()
        GlobalSingleton.register(listener)
    }

    override fun onDestroy() {
        super.onDestroy()
        GlobalSingleton.unregister(listener)
    }

    private class Listener : GlobalSingletonListener {
        override fun onEvent() {}
    }
}