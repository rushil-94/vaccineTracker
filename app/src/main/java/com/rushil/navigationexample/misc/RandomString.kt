package com.rushil.navigationexample.misc

import java.lang.IllegalArgumentException
import java.security.SecureRandom
import java.util.*

class RandomString {
    private val CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz"
    private val CHAR_UPPER = CHAR_LOWER.uppercase(Locale.getDefault())
    private val NUMBER = "0123456789+/"
    private val DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER

    private val secureRandom = SecureRandom()

    fun generateRandomString(s: String, length: Int): String {

        if (length < 1) {
            throw IllegalArgumentException()
        }
        val builder: StringBuilder = StringBuilder()
        for (i: Int in 0 until length) {
            val randCharAt = secureRandom.nextInt(s.length)
            val rndChar: Char = DATA_FOR_RANDOM_STRING[randCharAt]
            builder.append(rndChar)
        }

        return builder.toString()
    }
}