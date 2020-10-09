package searchAndSort

class BubbleSort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("** output "+ bubbleSort(mutableListOf(8, 5, 2, 9, 5, 6, 3)))
            println("** output "+ bubbleSortArray(intArrayOf(8, 5, 2, 9, 5, 6, 3)).toList())
        }
    }
}

fun bubbleSort(array: MutableList<Int>): List<Int> {
    while (true) {
        var isSwap = false
        for (i in 0..array.size - 2) {
            if (array[i] > array[i + 1]) {
                isSwap = true
                val temp = array[i]
                array[i] = array[i + 1]
                array[i + 1] = temp
            }
        }
        if(!isSwap) break
    }
    return array
}

fun bubbleSortArray(array: IntArray): IntArray {
    var isSorted = false
    // this counter is required as last element is in sorted order after each inner loop
    var counter = 0
    while (!isSorted) {
        isSorted = true
        for(i in 0 until array.size - 1 - counter) {
            if(array[i] > array[i + 1]) {
                isSorted = false
                val temp = array[i]
                array[i] = array[i + 1]
                array[i + 1] = temp
            }
        }
        counter ++
    }
    return array
}