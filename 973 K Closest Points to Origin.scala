import scala.collection.mutable.PriorityQueue
object Solution {
    def kClosest(points: Array[Array[Int]], K: Int): Array[Array[Int]] = {
        val pq = new PriorityQueue[(Int, Array[Int])]()(Ordering.by(_._1))
        for (p<- points) {
            pq += (( p(0) * p(0) + p(1) *p(1), p))
            if (pq.size > K) pq.dequeue
        }
        pq.toArray.map(_._2)
    }
}