package strings

import java.lang.StringBuilder
import java.util.*

/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/



Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 */
class RemoveDuplicates {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("output" + removeDuplicateLetters("cbacdcbc"))
        }
    }
}

fun removeDuplicateLetters(s: String): String {
    val countArray = Array(26) { i -> 0}
    val visitedArray = Array(26) { i -> false}
    for(i in 0 until s.length) {
        countArray[s[i] - 'a'] += 1
    }

    // can use stringbuilder n keep on removing length-1 char
    val stack = Stack<Char>()
    for(i in 0 until s.length) {
        countArray[s[i] - 'a'] -= 1

        if(visitedArray[s[i] - 'a']) continue

        while (!stack.isEmpty() && s[i] < stack.peek() && countArray[stack.peek() - 'a'] > 0) {
            visitedArray[stack.pop() - 'a'] = false
        }
        stack.push(s[i])
        visitedArray[s[i] - 'a'] = true
    }

    val result = StringBuilder()
    while (!stack.isEmpty()) {
        result.append(stack.pop())
    }
    return result.toString().reversed()
}

fun removeDuplicateLettersSimple(s: String): String {
    val charArray = Array(26) { i -> 0}
    var result = ""
    for(i in 0 until s.length) {
        var char = (s[i] - 97).toInt()
        charArray[char] += 1
    }
    for(i in charArray.indices) {
        if(charArray[i] > 0) {
            result += (i + 97).toChar()
        }
    }
    return result
}