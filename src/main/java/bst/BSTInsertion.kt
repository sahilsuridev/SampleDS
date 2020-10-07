package bst

import graph.combinationSumUnique

class BSTInsertion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //2,5,2,1,2
            val root = insertIntoBST(null, 4)
            insertIntoBST(root, 5)
        }
    }
}

fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
    var node = root
    if(node == null) {
        node = TreeNode(`val`)
        return node
    }

    while (node != null) {
        if(`val` < node.`val` && node.left != null ) {
            node = node.left
        } else if(`val` > node.`val` && node.right != null) {
            node = node.right
        } else {
            if(`val` < node.`val`) {
                node.left = TreeNode(`val`)
            } else {
                node.right = TreeNode(`val`)
            }
            break
        }
    }
    return root
}

 class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
 }


/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

}