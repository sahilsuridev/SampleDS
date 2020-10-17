package arrays

class Search2DMatrix {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("*** output "+searchMatrix(arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,50)), 3))
            println("*** output "+searchMatrix(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)), 2))
        }
    }
}

// [[1,3,5,7],[10,11,16,20],[23,30,34,50]]


fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if(matrix.isEmpty()) return false
    val rows = matrix.size
    val columns = matrix[0].size
    var left = 0
    var right = (rows * columns) -1
    while (left < right) {
        val midIndex = (left + right)/2
        val midElement = matrix[midIndex/columns][midIndex%columns]
        if(target == midElement) return true
        else if (target > midElement) left = midIndex + 1
        else right = midIndex - 1
    }
    return false
}