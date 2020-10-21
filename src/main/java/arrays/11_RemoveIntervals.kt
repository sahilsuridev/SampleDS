package arrays
/* Remove Covered Intervals

Solution
Given a list of intervals, remove all intervals that are covered by another interval in the list.

Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.

After doing so, return the number of remaining intervals.



Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
Example 2:

Input: intervals = [[1,4],[2,3]]
Output: 1 */


class RemoveIntervals {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("output " + removeCoveredIntervals(arrayOf(intArrayOf(1,3), intArrayOf(1,4), intArrayOf(3,6), intArrayOf(2,8))))
            println("output " + removeCoveredIntervalsSecond(arrayOf(intArrayOf(1,3), intArrayOf(1,4), intArrayOf(3,6), intArrayOf(2,8))))
        }
    }
}

fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
    var result = intervals.size
    intervals.sortWith(object : Comparator<IntArray> {
        override fun compare(s1: IntArray, s2: IntArray): Int {
            if(s1[0] == s2[0]) return s2[1] - s1[1]
            else return s1[0] - s2[0]
        }

    })
    var maxEnd = intervals[0][1]
    for (i in 1 until intervals.size) {
        if(maxEnd >= intervals[i][1]) {
            result --
        }
        maxEnd = Math.max(maxEnd, intervals[i][1])
    }
    return result
}

// 1,4 1,3 2,8 3,6

fun removeCoveredIntervalsSecond(intervals: Array<IntArray>): Int {
    var result = intervals.size
    intervals.sortWith(Comparator { s1, s2 -> s1[0] - s2[0] })
    var currInt = intArrayOf(-1, -1)
    for(interval in intervals) {
        if(currInt[0] <= interval[0] && currInt[1] >= interval[1]) {
            result --
        } else {
            if(currInt[0] == interval[0] && currInt[1] <= interval[1])
                result --
            currInt = interval;
        }
    }
    return result
}