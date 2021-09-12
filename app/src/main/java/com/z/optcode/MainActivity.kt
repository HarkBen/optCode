package com.z.optcode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.opt.libb.utils.LibBUtils
import com.opt.libb.data.LibBInfo
import com.z.optcode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val vb by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    val gson =  Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)

        vb.btnWebView.setOnClickListener {
            startActivity(Intent(this,WebViewActivity::class.java))
        }
        LibBUtils.fileLog()
        LibBUtils.showToast("showToast")

        jsonB()

    }

    private fun jsonB(){
        val libBInfo = LibBInfo("LibBInfo",1)
        val jsonA  = gson.toJson(libBInfo)
        jsonA.log("lib-b")
        val libaG = gson.fromJson(jsonA,LibBInfo::class.java)
        libaG.toString().log("lib-b")
    }
}