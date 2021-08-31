package com.rushil.navigationexample

import com.rushil.navigationexample.misc.encodeStringSHA256
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

    }

    @Test
    fun generate_encodeStringSHA256(input: String) {
        println(input.encodeStringSHA256())
    }
}