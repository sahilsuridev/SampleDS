package graph

class ClonedGraph {
}



 class Node(var `val`: Int) {
     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 }


fun cloneGraph(node: Node?): Node? {
    if(node == null) return node
    val nodeMaps = mutableMapOf<Int, Node>()
    return cloneGraphHelper(node, nodeMaps)
}

private fun cloneGraphHelper(node: Node, nodeMaps: MutableMap<Int, Node>): Node {
    if(nodeMaps.containsKey(node.`val`)) return nodeMaps[node.`val`] as Node
    val copyNode = Node(node.`val`)
    nodeMaps[node.`val`] = copyNode
    for(neighbour in node.neighbors) {
        copyNode.neighbors.add(cloneGraphHelper(neighbour as Node, nodeMaps))
    }

    return copyNode
}
