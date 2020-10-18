package graph

class DepthFirstSearch_32(name: String) {
    val name: String = name
    val children = mutableListOf<DepthFirstSearch_32>()

    fun depthFirstSearch(): List<String> {
        // Write your code here.
        val result = mutableListOf<String>()
        depthFirstSearchHelper(result, this)
        return result
    }

    fun depthFirstSearchHelper(result: MutableList<String>, depthFirstSearch: DepthFirstSearch_32) {
        result.add(depthFirstSearch.name)
        if(depthFirstSearch.children.size == 0) {
            return
        }
        for (child in depthFirstSearch.children) {
            depthFirstSearchHelper(result, child)
        }
    }
}