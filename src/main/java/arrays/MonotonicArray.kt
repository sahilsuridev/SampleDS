package arrays

class MonotonicArray {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("** output "+ isMonotonic(mutableListOf(-1, -5, -10, -1100, -1100, -1101, -1102, -9001)))
        }
    }
}

fun isMonotonic(array: List<Int>): Boolean {
    if(array.size <= 2) return true

    var direction = array[1] - array[0]
    for (i in 2 until array.size) {
        if(direction == 0) {
            direction = array[i] - array[i -1]
            continue
        }
        if(breakDirection(direction, array[i-1], array[i])) return false
    }
    return true
}

fun breakDirection(direction: Int, firstNum: Int, secondNum: Int): Boolean {
    if(direction > 0 && secondNum <= firstNum) return true
    else if(direction < 0 && secondNum >= firstNum) return true
    return false
}
