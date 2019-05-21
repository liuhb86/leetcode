import scala.collection.mutable.PriorityQueue
object Solution {
    def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
        val pq = new PriorityQueue[(Int, Int, Int)]()(Ordering.by(-_._1))
        for (i<-0 until matrix.length) pq += ((matrix(i).head, i, 0))
        var j = 1
        while(j < k) {
            val (n, x, y) = pq.dequeue
            if (y < matrix.length -1) pq += ((matrix(x)(y+1),x,y+1))
            j += 1
        }
        pq.head._1
    }
}