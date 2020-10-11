package arrays

import kotlin.math.min

/*
 Minimum Number of Arrows to Burst Balloons
There are some spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start and end of the diameter suffice. The start is always smaller than the end.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps traveling up infinitely.

Given an array points where points[i] = [xstart, xend], return the minimum number of arrows that must be shot to burst all balloons.



Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6])

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
Example 3:

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2

[[-2147483646,-2147483645],[2147483646,2147483647]]

Soln
1. We need to sort the input points, and we can use STL sorting directly.
Since the STL sorting pairs will sort the first element in advance, if the first element are equal, then it’ll sort based on second element.
2. We can see that if the end value overlaps other’s start value, we can use one arrow to burst them.
3. If a balloon’s start is greater than current end value, then we need a new arrow.
 */


class ArraysBallons {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            /*println("output " + findMinArrowShots(arrayOf(intArrayOf(9,12), intArrayOf(1,10), intArrayOf(4, 11), intArrayOf(8, 12),
                    intArrayOf(3,9), intArrayOf(6, 9), intArrayOf(6, 7))))*/
            println("output " + findMinArrowShotsTwo(arrayOf(intArrayOf(1,2), intArrayOf(3,4), intArrayOf(5,6), intArrayOf(7,8))))
            println("output " + findMinArrowShotsTwo(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(4,5))))
            println("output " + findMinArrowShotsTwo(arrayOf(intArrayOf(-2147483646,-2147483645), intArrayOf(2147483646,2147483647))))
            println("output " + findMinArrowShotsTwo(arrayOf(intArrayOf(3,9), intArrayOf(7,12), intArrayOf(3,8), intArrayOf(6,8),
                    intArrayOf(9,10), intArrayOf(2,9), intArrayOf(0,9), intArrayOf(3,9), intArrayOf(0,6), intArrayOf(2,8))))
        }
    }
}

//Input:
//[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
//Output:
//1
//Expected:
//2

//Input:
//[[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]
//Output:
//1
//Expected:
//2

//Input:
//[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
//Output:
//3
//Expected:
//2

//Input:
//[[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]
//Output:
//1
//Expected:
//2
fun findMinArrowShots(points: Array<IntArray>): Int {
    points.sortWith(object : Comparator<IntArray> {
        override fun compare(s1: IntArray, s2: IntArray): Int {
            return when {
                s1[0] > s2[0] -> return 1
                s2[0] > s1[0] -> return -1
                else -> {
                    if(s1[1] > s2[1]) return 1
                    else if(s2[1] > s1[1]) return -1
                    else return 0
                }
            }
        }
    })
    if(points.isNullOrEmpty()) return 0
    var index = 0
    var counter = 1
    var cordinate = points[index][1]
    index = 1
    while (index < points.size) {
        if(points[index][0] <= cordinate) {
            cordinate = min(cordinate, points[index][1])
        } else {
            counter ++
            cordinate = points[index][1]
        }
        index ++
    }
    return counter
}

fun findMinArrowShotsTwo(points: Array<IntArray>): Int {
    points.sortWith(object : Comparator<IntArray> {
        override fun compare(s1: IntArray, s2: IntArray): Int {
            return when {
                s1[1] > s2[1] -> return 1
                s2[1] > s1[1] -> return -1
                else -> {
                    return 0
                }
            }
        }
    })
    if(points.isNullOrEmpty()) return 0
    var index = 0
    var counter = 1
    var cordinate = points[index][1]
    index = 1
    while (index < points.size) {
        if(points[index][0] <= cordinate) {
            index ++
            continue
        } else {
            counter ++
            cordinate = points[index][1]
        }
        index ++
    }
    return counter
}
/*
We know that eventually we have to shoot down every balloon, so for each ballon there must be an arrow whose position is between balloon[0] and balloon[1]. Given that, we can sort the array of balloons by their ending position. Then we make sure that while we take care of each balloon from the beginning, we can shoot as many following balloons as possible.
So what position should we pick? We should shoot as right as possible, because all balloons' end position is to the right of the current one. Therefore the position should be currentBalloon[1], because we still need to shoot down the current one.
This is exactly what I do in the for loop: check how many balloons I can shoot down with one shot aiming at the ending position of the current balloon. Then I skip all these balloons and start again from the next one (or the leftmost remaining one) that needs another arrow.
Example:
balloons = [[7,10], [1,5], [3,6], [2,4], [1,4]]
After sorting, it becomes:
balloons = [[2,4], [1,4], [1,5], [3,6], [7,10]]
So first of all, we shoot at position 4, we go through the array and see that all first 4 balloons can be taken care of by this single shot. Then we need another shot for one last balloon. So the result should be 2.
 */