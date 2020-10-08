package List
/*
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {

    }
}
 */
class ReverseList {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val node1 = ListNode(1)
            val node2 = ListNode(2)
            val node3 = ListNode(3)
            val node4 = ListNode(4)
            val node5 = ListNode(5)
            node1.next = node2
            node2.next = node3
            node3.next = node4
            node4.next = node5
            var node6 = rotateRight(node1, 2)
            while (node6 != null) {
                println("**** "+node6?.`val`)
                node6 = node6?.next
            }
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun rotateRightLeetCode(head: ListNode?, k: Int): ListNode? {
    if(head == null || head.next == null) return head
    var counter = k
    var length = 1
    var newHead = head
    var tail = head
    while (tail?.next != null) {
        length ++
        tail = tail.next
    }
    counter %= length
    if(counter == 0) return newHead

    // Input: 1->2->3->4->5->NULL, k = 2
    //Output: 4->5->1->2->3->NULL
    tail?.next = head
    var steps = length - counter
    while (steps -- > 0) {
        tail = tail?.next
    }
    newHead = tail?.next
    tail?.next = null

    return newHead
}

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if(head == null || head.next == null) return head
    var newHead = head
    var tail = head
    var KNode = head
    var counter = 0
    while (tail?.next != null) {
        if(counter ++ < k) {
            KNode = KNode?.next
        }
        tail = tail?.next
    }
    newHead = KNode?.next
    tail?.next = head
    KNode?.next = null

    return newHead
}


fun rotateRightBruteForce(head: ListNode?, k: Int): ListNode? {
    if(head == null || head.next == null) return head
    var counter = k
    var newHead = head
    var lastNode = newHead.next
    var prevNode = newHead

    while (counter > 0 ) {
        counter--
        while(lastNode?.next != null) {
            prevNode = lastNode
            lastNode = lastNode.next
        }
        lastNode?.next = newHead
        prevNode?.next = null
        newHead = lastNode
        prevNode = newHead
        lastNode = newHead?.next
    }

    return newHead
}