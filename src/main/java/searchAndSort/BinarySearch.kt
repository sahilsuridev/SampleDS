package searchAndSort
/*
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].
 */
class BinarySearch {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("** output" + search(intArrayOf(-1,0,3,5,9,12), 9))
            println("** output" + search(intArrayOf(5), 5))
        }
    }
}

fun search(nums: IntArray, target: Int): Int {
    if(nums.isEmpty()) -1
    var lowIndex = 0
    var highIndex = nums.size - 1
    while (lowIndex <= highIndex) {
        val mid = ( lowIndex + highIndex ) / 2
        when {
            target == nums[mid] -> return mid
            target > nums[mid] -> lowIndex = mid + 1
            else -> highIndex = mid - 1
        }
    }
    return -1
}