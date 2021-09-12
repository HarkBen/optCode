package com.opt.lib

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class LibBActivity:Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(TextView(this).apply {
            text = "LibBActivity"
        })
    }
}