package strings

import java.lang.StringBuilder

class BuddyStrings {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("** buddy string "+buddyStrings("ab","ba"))
        }
    }
}

fun buddyStrings(str1: String, str2: String): Boolean {
    if(str1.length < 2 || str2.length < 2 || str1.length != str2.length) return false
    val diff = mutableListOf<Int>()
    val countArray = Array(26) { i -> 0}
    for(i in str1.indices) {
        countArray[str1[i] - 'a']++
        if(str1[i] != str2[i]) {
            diff.add(i)
            if(diff.size > 2) return false
        }
    }
    if(diff.size == 0) {
        for(i in countArray.indices) {
            if(countArray[i] >= 2) return true
        }
    }
    if(diff.size == 1) return false

    return str1[diff[0]] == str2[diff[1]] && str1[diff[1]] == str2[diff[0]]
}