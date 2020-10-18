package searchAndSort

class InsertionSort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("** output "+ insertionSort(mutableListOf(8, 5, 2, 9, 5, 6, 3)))
        }
    }
}

fun insertionSort(array: MutableList<Int>): List<Int> {
    // start from 1st index element, as 0th index is already sorted
    for(i in 1 until array.size) {
        var j = i

        // now compare from ith to 0 element till the previous number is greater
        while (j > 0 && array[j- 1] > array[j]) {
            val temp = array[j]
            array[j] = array[j - 1]
            array[j - 1] = temp
            j--
        }
    }
    return array
}