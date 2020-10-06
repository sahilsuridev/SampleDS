package graph


/* Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Input: candidates = [1], target = 2
Output: [[1,1]]


Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500
*/
class CombinationSum {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("output: "+ combinationSum(intArrayOf(2, 3, 5), 8))
        }
    }
}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

    return combinationSumHelper(candidates, mutableListOf(), 0, target, mutableListOf())
}

fun combinationSumHelper(candidates: IntArray, currentArray: MutableList<Int>, index: Int = 0, target: Int,
                         combinations: MutableList<List<Int>>): List<List<Int>> {
    if(target <= 0) {
        if(target == 0) {
            combinations.add(currentArray.toList())
        }
        return combinations
    }
    if(index < candidates.size) {
        val valueCheck = candidates[index]
        // here we are adding value in currentSum Array
        currentArray.add(valueCheck)
        // This call is for same repetition of the number, like 2,2,2,2
        combinationSumHelper(candidates, currentArray, index, target - valueCheck, combinations)

        // here remove the last in currentSum Array and check with next index value
        currentArray.removeAt(currentArray.size - 1)
        combinationSumHelper(candidates, currentArray, index + 1, target, combinations)
    }
    return combinations
}