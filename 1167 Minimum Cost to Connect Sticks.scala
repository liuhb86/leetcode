object Solution {
    def connectSticks(sticks: Array[Int]): Int = {
        val pq = scala.collection.mutable.PriorityQueue[Int]()(Ordering.by(-_))
        for (s<-sticks) pq += s
        var r = 0
        while (pq.size > 1) {
            val c = pq.dequeue + pq.dequeue
            r += c
            pq += c
        }
        r
    }
}