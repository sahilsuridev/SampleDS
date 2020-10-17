package strings
/*
All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.



Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 */
class RepeatedDna {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //=["AAAAAAAAAA"]
            println("** repeated DNA"+ findRepeatedDnaSequences("AAAAAAAAAAA"))
            println("** repeated DNA"+ findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
        }
    }
}

fun findRepeatedDnaSequences(s: String): List<String> {
    val setSequence = HashSet<String>()
    val repeatedSet = HashSet<String>()
    var i = 0
    while ( i + 10 <= s.length) {
        if(setSequence.contains(s.substring(i, i+10))) {
            repeatedSet.add(s.substring(i, i+10))
        } else {
            setSequence.add(s.substring(i, i+10))
        }
        i+=1
    }
    return repeatedSet.toList()
}