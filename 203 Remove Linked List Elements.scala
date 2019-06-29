/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def removeElements(head: ListNode, `val`: Int): ListNode = {
        val h = new ListNode()
        var last = h 
        var p = head
        while (p!=null) {
            if (p.x != `val`) {
                last.next = p
                last = p
            }
            p = p.next
        }
        last.next = null
        h.next
    }
}