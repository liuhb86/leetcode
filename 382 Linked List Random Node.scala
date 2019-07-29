/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
class Solution(_head: ListNode) {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    

    /** Returns a random node's value. */
    def getRandom(): Int = {
        var i = 0
        var p = _head
        var r = 0
        while(p != null) {
            i += 1
            val x = scala.util.Random.nextInt(i)
            if (x == 0) r = p.x
            p = p.next
        }
        r
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(head)
 * var param_1 = obj.getRandom()
 */