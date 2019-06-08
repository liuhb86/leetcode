import scala.collection.mutable.PriorityQueue
object Solution {
    def topKFrequent(words: Array[String], k: Int): List[String] = {
        val f = words.groupBy(identity).mapValues(_.length)
        val pq = new PriorityQueue[(Int, String)]()(
            Ordering.Tuple2(Ordering[Int].reverse, Ordering[String]))
        for ((s, v) <- f) {
            pq += ((v,s))
            if (pq.length > k) pq.dequeue
        }
        pq.dequeueAll.toList.reverse.map(_._2)
    }
}