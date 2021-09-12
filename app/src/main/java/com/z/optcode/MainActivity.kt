package com.z.optcode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.opt.liba.data.LibAInfo
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
        LibBUtils.showToast(this,"LibAUtils")
//        jsonA()

        jsonB()

    }
    private fun jsonA(){
        val libAInfo = LibAInfo("LibAInfo",1)
        val jsonA  = gson.toJson(libAInfo)
        jsonA.log("lib-a")
        val libaG = gson.fromJson(jsonA,LibAInfo::class.java)
        libaG.toString().log("lib-a")
    }
    private fun jsonB(){
        val libBInfo = LibBInfo("LibBInfo",1)
        val jsonA  = gson.toJson(libBInfo)
        jsonA.log("lib-b")
        val libaG = gson.fromJson(jsonA,LibBInfo::class.java)
        libaG.toString().log("lib-b")
    }
}