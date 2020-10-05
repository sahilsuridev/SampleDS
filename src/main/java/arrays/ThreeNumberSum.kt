package arrays

class ThreeNumberSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = threeNumberSum(mutableListOf(12, 3, 1, 2, -6, 5, -8, 6), 0)
            println("** output "+result)
        }
    }
}

    fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
        // Write your code here
        array.sort()
        val result = mutableListOf<List<Int>>()
        for(i in 0 .. array.size - 3) {
            var leftPointer = i + 1
            var rightPointer = array.size - 1
            while(leftPointer < rightPointer) {
                val currentSum = array[i] + array[leftPointer] + array[rightPointer]
                if(currentSum == targetSum) {
                    val foundList = listOf(array[i], array[leftPointer], array[rightPointer])
                    result.add(foundList)
                    leftPointer ++
                    rightPointer --
                } else if(currentSum < targetSum) {
                    leftPointer ++
                } else {
                    rightPointer --
                }
            }
        }
        return result
    }