package bst

import java.util.*

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var root = TreeNode(5)
            var rootLeft = TreeNode(3)
            var rootRight = TreeNode(8)
            root.left = rootLeft
            root.right = rootRight

            var node1 = TreeNode(2)
            rootLeft.left = node1
            val result = serialize(root)
            println("*** "+result)
            val node = deserialize(result)
            val result2 = serialize(root)
            println("*** "+result2)
        }
    }
}
//           5
//        /    \
//       3      8
//      /
//     2

// Encodes a URL to a shortened URL.
fun serialize(root: TreeNode?): String {
    return preOrderBst(root)
}

fun preOrderBst(node: TreeNode?) : String {
    if(node == null) return "#,"
    var result = node.`val`.toString()
    result += "," + preOrderBst(node.left) + preOrderBst(node.right)
    return result
}

// Decodes your encoded data to tree.
fun deserialize(data: String): TreeNode? {
    val nodes: Queue<String> = LinkedList()
    val split = data.split(",")
//    var length = data.length
//    for(i in 0 until length) {
//        nodes.add(data[i].toString())
//    }
    nodes.addAll(split)
    return deserializeHelper(nodes)
}

fun deserializeHelper(nodes: Queue<String>): TreeNode? {
    val nodeValue = nodes.poll()
    if(nodeValue == "#" || nodeValue.isNullOrEmpty()) return null

    val node = TreeNode(nodeValue.toInt())
    node.left = deserializeHelper(nodes)
    node.right = deserializeHelper(nodes)
    return node
}

/**
 * Your Codec object will be instantiated and called as such:
 * val ser = Codec()
 * val deser = Codec()
 * val tree: String = ser.serialize(root)
 * val ans = deser.deserialize(tree)
 * return ans
 */