package org.example.test

import org.example.SplitArray
import kotlin.test.*

class DataClassTest {
    @Test
    fun consume() {
        val head = intArrayOf(0, 1, 2)
        val tail = intArrayOf(3, 4)
        val array = SplitArray(head, tail)
        assertEquals("SplitArray(head=[0, 1, 2], tail=[3, 4])", array.toString())
        assertEquals(925602, array.hashCode())
    }
}