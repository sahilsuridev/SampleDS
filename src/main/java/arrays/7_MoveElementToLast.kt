package arrays

class MoveElementToLast {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("** output "+ moveElementToEnd(mutableListOf(5, 5, 5, 5, 5, 5, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12), 5))
        }
    }
}

fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
    // Write your code here.
    if(array.size == 1) return array
    var lastIndex = array.size - 1
    var index = 0
    while (index < lastIndex) {
        if(array[index] == toMove) {
            while (array[lastIndex] == toMove && lastIndex > index) {
                lastIndex --
            }
            val swapVar = array[lastIndex]
            array[lastIndex] = array[index]
            array[index] = swapVar
        }
        index++
    }
    return array
}