package arrays
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one duplicate number in nums, return this duplicate number.

Follow-ups:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem without modifying the array nums?
Can you solve the problem using only constant, O(1) extra space?
Can you solve the problem with runtime complexity less than O(n2)?
 */
class DuplicateNumber {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println("*** "+ findDuplicate(intArrayOf(1,3,4,2,2)))
        }
    }
}

fun findDuplicate(nums: IntArray): Int {
    var slowPointer = nums[0]
    var fastPointer = nums[0]
    do {
        slowPointer = nums[slowPointer]
        fastPointer = nums[nums[fastPointer]]
    } while (slowPointer != fastPointer)

    // move the fast pointer back to 0
    fastPointer = nums[0]
    while (slowPointer != fastPointer) {
        slowPointer = nums[slowPointer]
        fastPointer = nums[fastPointer]
    }
    // return slow or fast pointer
    return slowPointer
}