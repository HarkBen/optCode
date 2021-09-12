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
        val appInfo = AppInfo("测试混淆APP","1.0")
        gson.toJson(appInfo).log("host appInfo------")
        val jsonA  = "{\"name\":\"jsonHost\",\"versionName\":\"1.0\"}"
        jsonA.log("jsonA--")
        val appInfoG:AppInfo = gson.fromJson(jsonA,AppInfo::class.java)
        "$appInfoG".log("appInfoG--")
    }

    private fun jsonB(){
        val libBInfo= LibBInfo("库-libB",99)
        gson.toJson(libBInfo).log("libB libBInfo------")
        val jsonB  = "{\"age\":1,\"name\":\"LibBInfo\"}"
        jsonB.log("jsonB--")
        val libBG:LibBInfo = gson.fromJson(jsonB,LibBInfo::class.java)
        "$libBG".log("libBG--")

    }
}