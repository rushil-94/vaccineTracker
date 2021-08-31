package com.rushil.navigationexample.misc

import android.util.Log
import java.lang.StringBuilder
import java.security.MessageDigest

fun String.encodeStringSHA256(): String {
    val md = MessageDigest.getInstance("SHA-256")
    md.update(this.toByteArray())
    val encodeMsg: ByteArray = md.digest()

    val s = StringBuilder()
    for (i: Int in encodeMsg.indices) {
        s.append(String.format("%02x", encodeMsg[i]))
    }
    return s.toString()
}