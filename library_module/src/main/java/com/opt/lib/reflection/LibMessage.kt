package com.opt.lib.reflection

import java.lang.StringBuilder

class LibMessage{
    val name:String ="LibMessage"
    val type:Int = 1

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("LibMessage:toString ->")

        stringBuilder.append("fields.size -> ${this::class.java.declaredFields.size}")
        javaClass.declaredFields.forEach {
            stringBuilder.append(it.name)
            stringBuilder.append(":")
            stringBuilder.append(it.get(this))
            stringBuilder.append(",")
        }

        return stringBuilder.toString()
    }
}
