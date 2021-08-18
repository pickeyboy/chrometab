package com.example.myapplication

import junit.framework.TestCase

class MyStringUtilTest : TestCase() {

    fun testReverse() {
        assertEquals("to sydney to sydney Welcome", MyStringUtil.reverse("Welcome Welcome sydney to sydney to"))

    }
}