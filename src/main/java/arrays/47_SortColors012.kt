package arrays

class SortColor {
    // Dutch National Flag algo

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = intArrayOf(2,0,2,1,1,0)
            sortColors(arr)
            println("** output "+ arr.toList())
        }
    }
}

fun sortColors(nums: IntArray): Unit {
    if(nums.size <=1) return
    var low = 0
    var mid = 0
    var high = nums.size - 1
    while (mid <= high) {
        when(nums[mid]) {
            0 -> {
                val temp = nums[mid]
                nums[mid] = nums[low]
                nums[low] = temp
                low ++
                mid ++
            }
            1 -> {
                mid ++
            }
            2-> {
                val temp = nums[mid]
                nums[mid] = nums[high]
                nums[high] = temp
                high --
            }
        }
    }
}