package com.z.optcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.z.optcode.databinding.ActWebviewBinding

class WebViewActivity:AppCompatActivity() {
    val vb by lazy {
        ActWebviewBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
        vb.webView.settings.javaScriptEnabled = true
        vb.webView.loadUrl("https://www.baidu.com")

    }
}