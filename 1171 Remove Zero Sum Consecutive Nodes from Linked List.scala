/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def removeZeroSumSublists(head: ListNode): ListNode = {
        var removed = true
        val f = new ListNode()
        f.next = head
        while(removed && f.next != null) {
            val map = scala.collection.mutable.Map[Int, ListNode]()
            map(0) = f
            removed = false
            var p = f.next
            var s = 0
            while (!removed && p!= null) {
                s += p.x
                if (map.contains(s)) {
                    map(s).next = p.next
                    removed = true
                } else {
                    map(s) = p
                    p = p.next
                }
            }
        }
        f.next
    }
}