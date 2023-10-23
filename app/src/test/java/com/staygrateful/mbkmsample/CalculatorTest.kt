package com.staygrateful.mbkmsample

import org.junit.Assert.*
import org.junit.Test

class CalculatorTest {

    @Test
    fun sum_test() {
        val a = 1
        val b = 2
        val sum = Calculator.sum(a, b)
        assertEquals(3, sum)
    }
}