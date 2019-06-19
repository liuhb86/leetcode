import scala.collection.mutable.ArrayBuffer
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def nextLargerNodes(head: ListNode): Array[Int] = {
        val r = new ArrayBuffer[Int]()
        val s = new ArrayBuffer[(Int, Int)]()
        var i=0
        var p = head
        while (p != null) {
            val v = p.x
            while (s.nonEmpty && s.last._1 < v) {
                r(s.last._2) = v
                s.trimEnd(1)
            }
            r += 0
            s += ((v, i))
            i += 1
            p = p.next
        }
        r.toArray
    }
}