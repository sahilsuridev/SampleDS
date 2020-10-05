package bst

class BranchSum {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val tree = BinaryTree(1)
            tree.left = BinaryTree(2)
            tree.right = BinaryTree(3)
            tree.left!!.left = BinaryTree(4)
            tree.left!!.right = BinaryTree(5)
            tree.right!!.left = BinaryTree(6)
            tree.right!!.right = BinaryTree(7)
            tree.left!!.left!!.left = BinaryTree(8)
            tree.left!!.left!!.right = BinaryTree(9)
            tree.left!!.right!!.left = BinaryTree(10)

            val result = branchSums(tree)
            println("*** $result")
            val expected = listOf(15, 16, 18, 10, 11)
        }
    }

}

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

//0
//  1
//    10
//        100
fun branchSums(root: BinaryTree): List<Int> {
    // Write your code here.
    return branchSumsHelper(root, 0, mutableListOf())
}

fun branchSumsHelper(root: BinaryTree, currentSum: Int, toAdd: MutableList<Int>): List<Int> {
    // Write your code here.
    if(root.left == null && root.right == null) {
        toAdd.add(currentSum + root.value)
        return toAdd
    }
     else {
        if (root.left != null) {
            branchSumsHelper(root.left!!, currentSum + root.value, toAdd)
        }
        if (root.right != null) {
            branchSumsHelper(root.right!!, currentSum + root.value, toAdd)
        }
    }
    return toAdd
}