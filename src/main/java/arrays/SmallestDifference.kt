package arrays

class SmallestDifference {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("** output "+smallestDifference(mutableListOf(-1, 5, 10, 20, 28, 3),
                    mutableListOf(26, 134, 135, 15, 17)))
        }
    }

}

fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
    // Write your code here.
    arrayOne.sort()
    arrayTwo.sort()
    var difference = Int.MAX_VALUE
    val result = mutableListOf<Int>()
    var indexOne = 0
    var indexTwo = 0
    while (indexOne <= arrayOne.size - 1 && indexTwo <= arrayTwo.size - 1) {
        if(arrayOne[indexOne] == arrayTwo[indexTwo]) {
            result.clear()
            result.add(arrayOne[indexOne])
            result.add(arrayTwo[indexTwo])
            break
        } else if(arrayOne[indexOne] < arrayTwo[indexTwo]) {
            if(difference > arrayTwo[indexTwo] - arrayOne[indexOne]) {
                result.clear()
                difference = arrayTwo[indexTwo] - arrayOne[indexOne]
                result.add(arrayOne[indexOne])
                result.add(arrayTwo[indexTwo])
            }
            indexOne ++
        } else {
            if(difference > arrayOne[indexOne] - arrayTwo[indexTwo]) {
                result.clear()
                difference = arrayOne[indexOne] - arrayTwo[indexTwo]
                result.add(arrayOne[indexOne])
                result.add(arrayTwo[indexTwo])
            }
            indexTwo ++
        }
    }
    return result
}