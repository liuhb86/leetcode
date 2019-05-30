import scala.collection.mutable.PriorityQueue
object Solution {
    def largestSumAfterKNegations(A: Array[Int], K: Int): Int = {
        val sum = A.sum
        val pq = new PriorityQueue[Int]()
        for (n<-A) {
            pq += n
            if (pq.size > K) pq.dequeue
        }
        val (neg, pos) = pq.toArray.sorted.partition(_<0)
        //println(neg.mkString(","))
        //println(pos.mkString(","))
        if (neg.length >= K) {
            sum - neg.take(K).sum * 2
        } else if ((K - neg.length) % 2 == 0) {
            sum - neg.sum * 2
        } else {
            val t = 
                if (neg.isEmpty) pos.head
                else if (pos.isEmpty) -neg.last
                else scala.math.min(pos.head, -neg.last)
            sum - neg.sum * 2 - t* 2
        } 
    }
}