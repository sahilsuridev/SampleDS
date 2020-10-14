package searchAndSort

import List.ListNode

class MergeSort {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var ListNode1 = ListNode(4)
            var ListNode2 = ListNode(2)
            var ListNode3 = ListNode(1)
            var ListNode4 = ListNode(3)

            ListNode1.next = ListNode2
            ListNode2.next = ListNode3
            ListNode3.next = ListNode4
            var head: ListNode? = sortList(ListNode1)
            while (head != null) {
                println("--- "+head.`val`)
                head = head.next
            }
        }
    }
}

fun sortList(head: ListNode?): ListNode? {
    if(head == null || head.next == null) return head

    val nodeMiddle = getMiddle(head)
    val nextNodeMiddle = nodeMiddle?.next

    nodeMiddle?.next = null

    val nodeLeft = sortList(head)
    val nodeRight = sortList(nextNodeMiddle)
    val sortedList = sortedMerge(nodeLeft, nodeRight)
    return sortedList
}

fun getMiddle(head: ListNode?): ListNode? {
    if(head == null) return head
    var slowNode = head
    var fastNode = head
    while (fastNode?.next != null && fastNode.next?.next != null) {
        slowNode = slowNode?.next
        fastNode = fastNode.next?.next
    }
    return slowNode
}

fun sortedMerge(nodeA: ListNode? , nodeB: ListNode?): ListNode? {
    var result: ListNode?
    if(nodeA == null) return nodeB

    if(nodeB == null) return nodeA

    if(nodeA.`val` <= nodeB.`val`) {
        result = nodeA
        result.next = sortedMerge(nodeA.next, nodeB)
    } else {
        result = nodeB
        result.next = sortedMerge(nodeA, nodeB.next)
    }

    return result
}