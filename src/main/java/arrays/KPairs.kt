package arrays
/*
Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.

1 1 1 3 4 5

Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:

Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 */
class KPairs {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println("output "+findPairs(intArrayOf(1,2,4,4,3,3,0,9,2,3), 3))
//            println("output "+findPairs(intArrayOf(1,1,1,1,1), 0))
            println("output "+findPairs(intArrayOf(1,3,1,5,4), 0))
            //println("output "+findPairs(intArrayOf(1,1,1,2,2), 0))
        }
    }
}

fun findPairs(nums: IntArray, k: Int): Int {
    nums.sort()
    var index = 0
    var pairs = 0

    if(k == 0) {
        val map = mutableMapOf<Int, Int>()
        for(num in nums) {
            var value = map[num]
            if(value != null) ++value
            map[num] = value ?: 1
        }
        println("** map "+map)
        for(mapPair in map) {
            if(mapPair.value > 1) pairs++
        }
        return pairs
    }
    while (index <= nums.size - 2) {
        if(nums[index] == nums[index + 1]) {
            index ++
            //if(k == 0 && (index == nums.size - 2 && nums[index] == nums[index + 1])) pairs ++
            continue
        }
        for(i in (index + 1) until nums.size) {
            val difference = nums[i] - nums[index]
            if(difference == k) {
                if(i != nums.size - 1 && nums[i] == nums[i+1]) {
                    continue
                }
                pairs ++
            }
            if(difference > k) {
                break
            }
        }
        index ++
    }
    return pairs
}