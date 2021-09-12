package com.opt.libb.utils

import android.content.Context
import android.util.Log
import android.widget.Toast

object LibBUtils {

    fun fileLog(){
        Log.i("proguard_log","LibBUtils fileLog")
    }

    fun showToast(msg:String){
        Log.i("proguard_log","LibBUtils $msg")
    }
}