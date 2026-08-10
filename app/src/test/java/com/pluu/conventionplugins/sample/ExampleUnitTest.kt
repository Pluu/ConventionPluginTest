package com.pluu.conventionplugins.sample

import com.pluu.library.feature1.MyClass
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        println("▼▼▼▼▼Test Runtime▼▼▼▼▼")
        val k = MyClass()
        println(k.toString())
        println("▲▲▲▲▲Test Runtime▲▲▲▲▲")
        assertEquals(4, 2 + 2)
    }
}