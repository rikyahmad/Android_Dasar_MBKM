package com.staygrateful.mbkmsample.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.staygrateful.mbkmsample.R

class SampleKotlinActivity: AppCompatActivity() {

    var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        val msg = intent?.getStringExtra("MESSAGE")
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }
}