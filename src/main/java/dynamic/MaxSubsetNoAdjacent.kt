package dynamic

class MaxSubsetNoAdjacent {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            maxSubsetSumNoAdjacent(listOf(75, 105, 120, 75, 90, 135))
        }
    }
}

fun maxSubsetSumNoAdjacent(array: List<Int>): Int {
    var second = array[0]
    var first = Math.max(array[0], array[1])
    var currrent = Math.max(second, first)
    // Write your code here.
    for(i in 2 until array.size) {
        currrent = Math.max(first, second + array[i])
        first = second
        second = currrent
    }
    return currrent
}