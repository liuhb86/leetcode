import scala.collection.mutable.PriorityQueue
object Solution {
    def lastStoneWeight(stones: Array[Int]): Int = {
        val pq = new PriorityQueue[Int]()
        pq ++= stones
        while(!pq.isEmpty) {
            if (pq.length == 1) return pq.head
            val m1 = pq.dequeue
            val m2 = pq.dequeue
            if (m1 != m2) {
                pq += (m1-m2)
            }
        }
        0
    }
}