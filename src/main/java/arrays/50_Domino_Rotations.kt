package arrays

class `50_Domino_Rotations` {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("** output "+ minDominoRotations(intArrayOf(2,1,2,4,2,2), intArrayOf(5,2,6,2,3,2)))
        }
    }
}

fun minDominoRotations(A: IntArray, B: IntArray): Int {
    var minSwaps = Math.min(minSwapsHelper(A[0], A, B), minSwapsHelper(B[0], A, B))
    minSwaps = Math.min(minSwaps, minSwapsHelper(A[0], B, A))
    minSwaps = Math.min(minSwaps, minSwapsHelper(B[0], B, A))
    return if(minSwaps == Int.MAX_VALUE) -1 else minSwaps
}

fun minSwapsHelper(target: Int, targetArray:IntArray, swapArray:IntArray): Int {
    var minSwaps = 0
    for(i in targetArray.indices) {
        if(target != targetArray[i] && target != swapArray[i]) {
            return Int.MAX_VALUE
        } else if(target != targetArray[i]) {
            minSwaps ++
        }
    }
    return minSwaps
}