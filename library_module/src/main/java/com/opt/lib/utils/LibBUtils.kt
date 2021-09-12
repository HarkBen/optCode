package com.opt.lib.utils

import android.util.Log

object LibBUtils {

    fun fileLog(){
        Log.i("proguard_log","LibBUtils fileLog")
    }

    fun showToast(msg:String){
        Log.i("proguard_log","LibBUtils $msg")
    }
}