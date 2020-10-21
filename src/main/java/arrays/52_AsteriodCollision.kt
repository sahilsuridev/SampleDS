package arrays

import java.util.*

/*
We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */
class AsteriodCollision {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }
}

fun asteroidCollision(asteroids: IntArray): IntArray {
    val stack = Stack<Int>()
    // if the element is positive just push into stack, coz +ve movement is right, so negative at top of stack cannot collide with +ve
    // as it is going left and +ve +ve dont collide so are -ve -ve
    for(i in asteroids.indices) {
        if(stack.isEmpty() || asteroids[i] > 0) {
            stack.push(asteroids[i])
        } else {
            while (true) {
                if(stack.peek() < 0) {
                    // stack = -6           asteriod = -4
                    // stack = -4 -5
                    stack.push(asteroids[i])
                    break
                } else if(stack.peek() > -(asteroids[i])) {
                    // stack = 5           asteriod = -4
                    // stack []
                    break
                } else if(stack.peek() == -(asteroids[i])) {
                    // stack = 4           asteriod = -4
                    // stack []
                    stack.pop()
                    break
                } else {
                    // stack = 3 4           asteriod = -4
                    // stack 3               asteriod = -4
                    // stack []
                    stack.pop()
                    if(stack.isEmpty()) {
                        stack.push(asteroids[i])
                        break
                    }
                }
            }
        }
    }
    val result = Array(stack.size) {0}
    var i = 0
    for(value in stack) {
        result[i ++] = value
    }
    return result.toIntArray()
}