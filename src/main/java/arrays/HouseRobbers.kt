package arrays
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [0]
Output: 0
 */
class HouseRobbers {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("****" + rob(intArrayOf(2,3,2)))
        }
    }
}

fun rob(nums: IntArray): Int {
    if(nums.size == 0) return -1
    if(nums.size == 1) return nums[0]
    if(nums.size == 2) return Math.max(nums[0], nums[1])
    return Math.max(robHelper(nums, 0, nums.size -2), robHelper(nums, 1, nums.size -1))
}

fun robHelper(nums: IntArray, startIndex: Int, endIndex: Int):Int {
    if(endIndex - startIndex == 1) Math.max(nums[startIndex], nums[endIndex])
    var firstNum = nums[startIndex]
    var secondNum = Math.max(nums[startIndex], nums[startIndex + 1])

    for(i in startIndex + 2 ..endIndex) {
        val temp = secondNum
        secondNum = Math.max(secondNum, firstNum + nums[i])
        firstNum = temp
    }
    return secondNum
}


// 1 2 3 6

/*
firstNum = 1
secondNum = 2
temp = 2
secondNum = max(2, 1+3) -- 4
firstNum = 2

secondNum = max(4, 2+6) -- 4


 */