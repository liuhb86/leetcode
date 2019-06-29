/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def reverseList(head: ListNode): ListNode = {
        var t: ListNode = null
        var p = head
        while (p!= null) {
            val n = p.next
            p.next = t
            t = p
            p = n
        }
        t
    }
}