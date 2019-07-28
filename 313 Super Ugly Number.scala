import scala.collection.mutable.{Set, PriorityQueue}
object Solution {
    def nthSuperUglyNumber(n: Int, primes: Array[Int]): Int = {
        val pq = PriorityQueue[Long]()(Ordering.by(-_))
        val set = Set[Long]()
        pq += 1L
        for (i<- 1 until n) {
            val x = pq.dequeue
            for (p<-primes) {
                val m = x * p
                if (!set(m)) {
                    pq += m
                    set += m
                }
            }
        }
        pq.head.toInt
    }
}