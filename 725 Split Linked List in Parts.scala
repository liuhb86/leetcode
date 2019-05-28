/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
import scala.annotation.tailrec
object Solution {
    def splitListToParts(root: ListNode, k: Int): Array[ListNode] = {
        val length = len(root, 0)
        split(root, k, length, Nil).toArray.reverse
    }
    
    @tailrec
    def len(root: ListNode, _len: Int) : Int = {
        if (root == null) _len
        else len(root.next, _len+1)
    }
    
    @tailrec
    def split(root: ListNode, k: Int, len: Int, _r : List[ListNode]) : List[ListNode] = {
        if (k == 0) _r
        else {
            val t = if (len % k == 0) len / k else len / k + 1
            var n = root
            if (t > 0) {
                for (i<- 1 until t) n = n.next
                val m = n.next
                n.next = null
                n = m
            }
            split(n, k -1, len - t, root :: _r)
        }
    }
}