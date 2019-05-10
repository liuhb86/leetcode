import scala.annotation.tailrec
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def middleNode(head: ListNode): ListNode = {
        val len = length(head, 0)
        val mid = len / 2
        get(head, mid)
    }
    
    @tailrec
    def length(n : ListNode, len: Int) : Int = {
        if (n == null) len
        else length(n.next, len + 1)
    }
    
    @tailrec
    def get(n : ListNode, index: Int) : ListNode = {
        if (index == 0) n
        else get(n.next, index - 1)
    }
}