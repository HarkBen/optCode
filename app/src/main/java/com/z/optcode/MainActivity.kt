package com.z.optcode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.z.optcode.databinding.ActWebviewBinding
import com.z.optcode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val vb by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)

        vb.btnWebView.setOnClickListener {
            startActivity(Intent(this,WebViewActivity::class.java))
        }

    }
}