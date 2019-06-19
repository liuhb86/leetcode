/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def oddEvenList(head: ListNode): ListNode = {
        val o = new ListNode()
        val e = new ListNode()
        val lists = Array(o,e)
        var i = 0
        var n = head
        while (n != null) {
            lists(i).next = n
            lists(i) = n
            i = 1 - i
            n = n.next
        }
        lists(0).next = e.next
        lists(1).next = null
        o.next
    }
}