package com.z.optcode

import android.util.Log

fun String.log(secondTag:String){
    Log.i("proguard_log","$secondTag$this")
}