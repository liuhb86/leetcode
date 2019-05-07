/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
import scala.annotation.tailrec
object Solution {
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        val diff = len(l1) - len(l2)
        val (result, carry) = calc(l1, l2, diff)
        if (carry > 0) {
            val newNode = new ListNode(carry)
            newNode.next = result
            newNode
        } else {
            result
        }
    }
    
    @tailrec
    def len(list : ListNode, acc: Int = 0) : Int = list match {
        case null => acc
        case x : ListNode => len(x.next, acc + 1)
    }
    
    def calc(l1: ListNode, l2: ListNode, diff: Int) : (ListNode, Int) = {
        if (l1 == null && l2 == null) return (null, 0)
        var next1 = l1
        var next2 = l2
        var nextDiff = diff
        var result = 
            if (diff > 0) {
                next1 = l1.next
                nextDiff = diff - 1
                l1.x
            } else if (diff < 0) {
                next2 = l2.next
                nextDiff  = diff + 1
                l2.x
            } else {
                next1 = l1.next
                next2 = l2.next
                l1.x + l2.x
            }
        val (nextResult, carry) = calc(next1, next2, nextDiff)
        result += carry
        val newNode = new ListNode(result % 10)
        newNode.next = nextResult
        (newNode, result / 10)
    }
}