package com.opt.libb.utils

import android.content.Context
import android.widget.Toast

object LibBUtils {

    fun fileLog(){

    }

    fun showToast(context:Context,msg:String){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }
}