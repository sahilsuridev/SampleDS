package bst

class MinumumDepthBST {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }
}

fun minDepth(root: TreeNode?): Int {
    if(root == null) return 0
    if(root.left == null && root.right == null) return 1

    if(root.right == null) return minDepth(root.left) + 1
    if(root.left == null) return minDepth(root.right) + 1

    return Math.min(minDepth(root.left), minDepth(root.right)) + 1
}