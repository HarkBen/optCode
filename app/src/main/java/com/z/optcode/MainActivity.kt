package com.z.optcode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.opt.libb.utils.LibBUtils
import com.opt.libb.data.LibBInfo
import com.z.optcode.data.AppInfo
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
        jsonHost()
        jsonB()

    }

    private fun jsonHost(){
        val jsonA  = "{\"name\":\"LibBInfo\",\"versionName\":\"1.0\"}"
        jsonA.log("jsonHost")
        val appInfoG = gson.fromJson(jsonA,AppInfo::class.java)
        appInfoG.toString().log("jsonHost")
    }

    private fun jsonB(){
        val jsonA  = "{\"age\":1,\"name\":\"LibBInfo\"}"
        jsonA.log("jsonB")
        val libaG = gson.fromJson(jsonA,LibBInfo::class.java)
        libaG.toString().log("jsonB ")
    }
}