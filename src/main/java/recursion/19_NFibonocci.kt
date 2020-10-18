package recursion

class NFibonocci {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(getNthFib(4))
        }
    }
}

fun getNthFib(n: Int): Int {
    // Write your code here.
    var prev = 1
    var prevToPrev = 0
    var result = prev + prevToPrev
    for(i in 1 .. n-2) {
        result = prev + prevToPrev
        prevToPrev = prev
        prev = result
    }
    return result
}