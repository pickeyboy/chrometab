package com.example.myapplication

object MyStringUtil {

    fun reverse(theString: String): String {
        var reversedString = ""

        theString.split(" ").asReversed().let {
            var element = ""
            for (i in it.indices) {

                if (element != it.elementAt(i)) {
                    if (reversedString.isNotEmpty()) {
                        reversedString += " "
                    }
                    reversedString += it.elementAt(i)
                }
                element = it.elementAt(i)

            }
        }
        return reversedString
    }
}