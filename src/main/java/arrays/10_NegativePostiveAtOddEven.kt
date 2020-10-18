package arrays

class NegativePostiveAtOddEven {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("*** "+ negativePostiveAtOddEven(intArrayOf(1,2,3,4, -1, -2)).toList())
            println("*** "+ negativePostiveAtOddEven(intArrayOf(1,2,3,4,5,6,7,-1,-2)).toList())
            println("*** "+ negativePostiveAtOddEven(intArrayOf(-1,-2,-3,-4)).toList())
            println("*** "+ negativePostiveAtOddEven(intArrayOf(1,2,3,4)).toList())
            println("*** "+ negativePostiveAtOddEven(intArrayOf(-1,-2,-3,-4,5,6,7,-8,-9)).toList())
            println("*** "+ negativePostiveAtOddEven(intArrayOf(-1,-2,-3,-4,5,6,7,-8,-9, 10, 11, 12 ,13,14,15,16,17,18)).toList())

            println("*** "+ negativePostiveAtOddEvenSecond(intArrayOf(-1,-2,-3,-4)).toList())
            println("*** "+ negativePostiveAtOddEvenSecond(intArrayOf(1,2,3,4, -1, -2)).toList())
            println("*** "+ negativePostiveAtOddEvenSecond(intArrayOf(1,2,3,4,5,6,7,-1,-2)).toList())
            println("*** "+ negativePostiveAtOddEvenSecond(intArrayOf(-1,-2,-3,-4)).toList())
            println("*** "+ negativePostiveAtOddEvenSecond(intArrayOf(1,2,3,4)).toList())
            println("*** "+ negativePostiveAtOddEvenSecond(intArrayOf(-1,-2,-3,-4,5,6,7,-8,-9)).toList())
            println("*** "+ negativePostiveAtOddEvenSecond(intArrayOf(-1,-2,-3,-4,5,6,7,-8,-9, 10, 11, 12 ,13,14,15,16,17,18)).toList())
        }
    }
}

fun negativePostiveAtOddEven(nums: IntArray) :IntArray {
    var countPositive = 0
    var countNegative = 0
    for(i in nums.indices) {
        if(nums[i] >=0) countPositive ++
        else countNegative ++
    }
    var postiveIndex = -1
    var negativeIndex = -1
    if(countNegative > 0 && countPositive > 0) {
        postiveIndex = 0
        negativeIndex = 1
    } else if(countPositive > 0) postiveIndex = 0
    else negativeIndex = 0
    val result = IntArray(nums.size)
    for(i in nums.indices) {
        if(nums[i] >= 0) {
            result[postiveIndex] = nums[i]
            postiveIndex += if(countNegative -- > 0) 2 else 1
        } else {
            result[negativeIndex] = nums[i]
            negativeIndex += if(countPositive -- > 1) 2 else 1
        }
    }
    return result
}

/*
Positive elements at even and negative at odd positions (Relative order not maintained)
 */
fun negativePostiveAtOddEvenSecond(nums: IntArray) :IntArray {
    if(nums.size <=1) return nums
    var postive = 0
    var negative = 1
    while (true) {
        // find first -ve number on even places
        while (postive < nums.size && nums[postive] >= 0) postive+=2

        // find first +ve number on odd places
        while (negative < nums.size && nums[negative] < 0) negative+=2

        // swap the numbers if found above
        if(postive < nums.size && negative < nums.size) {
            val temp = nums[postive]
            nums[postive] = nums[negative]
            nums[negative] = temp
        } else if(postive < nums.size){
            var trackPostive = postive
            var found = false
            while (trackPostive< nums.size) {
                if(nums[trackPostive] > 0) {
                    found = true
                    break
                }
                trackPostive+=2
            }
            if(found) {
                val temp = nums[trackPostive]
                nums[trackPostive] = nums[trackPostive - 2]
                nums[trackPostive - 2] = temp
            } else {
                break
            }
        } else if(negative < nums.size ) {
            var trackNegative = negative
            var found = false
            while (trackNegative< nums.size) {
                if(nums[trackNegative] < 0) {
                    found = true
                    break
                }
                trackNegative+=2
            }
            if(found) {
                val temp = nums[trackNegative]
                nums[trackNegative] = nums[trackNegative - 2]
                nums[trackNegative - 2] = temp
            } else {
                break
            }
        } else break
    }
    return nums
}