package com.opt.lib

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.opt.lib.data.LibBInfo
import com.opt.lib.databinding.ActLibBBinding
import com.opt.lib.reflection.JavaMessage
import com.opt.lib.reflection.LibMessage
import com.opt.lib.ui.LibBUIView
import com.opt.lib.utils.LibBUtils

class LibBActivity:Activity() {
    val vb by lazy {
        ActLibBBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
        vb.tv.text = "LibBActivity"
        val view = LibBUIView(this,null)
        "quote：$view ${LibBUIView::class.java}".log()
        "quote：${LibBInfo::class.java}".log()
        "quote：${JavaMessage::class.java}".log()
        "quote：${LibMessage::class.java}".log()
        "quote：${LibBUtils::class.java}".log()

    }
}
private fun String.log(secondTag:String=""){
    Log.i("proguard_log","$secondTag->$this")
}