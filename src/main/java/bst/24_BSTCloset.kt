package bst

import java.lang.Math.abs

public class BSTCloset {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val tree = BST(10)
            tree.left = BST(5)
            tree.left!!.left = BST(2)
            tree.left!!.left!!.left = BST(1)
            tree.left!!.right = BST(5)
            tree.right = BST(15)
            tree.right!!.left = BST(13)
            tree.right!!.left!!.right = BST(14)
            tree.right!!.right = BST(22)

            val result = findClosestValueInBst(tree, 12)
            println("*** "+result)
        }
    }
}

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

fun findClosestValueInBst(tree: BST, target: Int): Int {
    // Write your code here.
    return findClosestValueInBstHelper(tree, target, tree.value)
}

fun findClosestValueInBstHelper(tree: BST, target:Int, closest: Int) : Int {
    var newClosest = closest
    if(abs(target - closest) > abs(target - tree.value))
        newClosest = tree.value
    if(tree.value < target && tree.right != null) {
        return findClosestValueInBstHelper(tree.right!!, target, newClosest)
    }
    else if(tree.value > target && tree.left != null) {
        return findClosestValueInBstHelper(tree.left!!, target, newClosest)
    }
    else return newClosest
}