import scala.collection.mutable.PriorityQueue
object Solution {
    def minMeetingRooms(intervals: Array[Array[Int]]): Int = {
        val pq = PriorityQueue[Int]()(Ordering.by(-_))
        for (Array(s,t) <- intervals.sortBy(_(0))) {
            if (pq.isEmpty) {
                pq += t
            } else {
                val m = pq.dequeue
                if (s>=m) {
                    pq += t
                } else {
                    pq += m
                    pq += t
                }
            }
        }
        pq.size
    }
}