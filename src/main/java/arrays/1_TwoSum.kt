package arrays

class TwoSum {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("** twoSum ?"+ twoSum(intArrayOf(2,7,11,15), 9).toList())
        }
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val mapNum = mutableMapOf<Int, Int>()
    for(i in nums.indices) {
        if(mapNum.containsKey(target - nums[i])) {
            val index = mapNum[target - nums[i]] as Int
            return intArrayOf(i, index)
        } else {
            mapNum[nums[i]] = i
        }
    }
    return intArrayOf()
}