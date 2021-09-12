package com.z.optcode

import android.os.Bundle
import android.webkit.JavascriptInterface
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
        vb.webView.addJavascriptInterface(JSBridge(),"JSBridge")

        val jsb = JSBridge()
        jsb.function3().log("")
    }

    private class JSBridge{
        @JavascriptInterface
        fun function1(){}

        @JavascriptInterface
        fun function2(){}

        fun function3():String{
            return "function3"
        }
    }

}